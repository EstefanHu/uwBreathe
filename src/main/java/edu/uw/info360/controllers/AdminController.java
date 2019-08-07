package edu.uw.info360.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.uw.info360.models.Node;
import edu.uw.info360.models.NodesResources;
import edu.uw.info360.models.Practice;
import edu.uw.info360.models.Resource;
import edu.uw.info360.services.NodeService;
import edu.uw.info360.services.NodesResourcesService;
import edu.uw.info360.services.PracticeService;
import edu.uw.info360.services.ResourceService;

@Controller
@RequestMapping("admin")
public class AdminController {
	private final PracticeService practiceService;
	private final NodeService nodeService;
	private final ResourceService resourceService;
	private final NodesResourcesService nrService;
	
	
	public AdminController( PracticeService practiceService,
							NodeService nodeService,
							ResourceService resourceService,
							NodesResourcesService nrService) {
		this.practiceService = practiceService;
		this.nodeService = nodeService;
		this.resourceService = resourceService;
		this.nrService = nrService;
	}
	@RequestMapping("")
	public String control(Model model) {
		List<Practice> practices = practiceService.findAllPractices();
		List<Node> nodes = nodeService.findAllNodes();
		List<Resource> resources = resourceService.findAllResources();
		model.addAttribute("resources", resources);
		model.addAttribute("nodes", nodes);
		model.addAttribute("practice", practices);
		return "Admin/control.jsp";
	}
//	Nodes Logic
	@RequestMapping("/createNode")
	public String createNode(@ModelAttribute("node") Node node) {
		return "Admin/createNode.jsp";
	}
	
	@RequestMapping(value="/ingestNewNode", method=RequestMethod.POST)
	public String ingestNewNode(@Valid @ModelAttribute("node") Node newNode, BindingResult result) {
//		TODO: Create Node Validation
		nodeService.createNode(newNode);
		return "redirect:/admin/";
	}
	
	@RequestMapping("/editNode/{id}")
	public String editNode(Model model, @PathVariable("id") Long id, @ModelAttribute("updateNode") Node updateNode) {
		Node node = nodeService.findNodeById(id);
		model.addAttribute("node", node);
		return "Admin/editNode.jsp";
	}
	
	@RequestMapping(value="/updateNode/{id}", method=RequestMethod.PUT)
	public String updateNode(@PathVariable("id") Long id, @ModelAttribute("updateNode") Node node) {
		nodeService.updateNode(id, node);
		return "redirect:/admin/";
	}
	
	@RequestMapping(value="/deleteNode/{id}", method=RequestMethod.DELETE)
	public String deleteNode(@PathVariable("id") Long id) {
		nodeService.deleteNode(id);
		return "redirect:/admin/";
	}
//	NodesResources Logic
	@RequestMapping("editResourceForNode/{id}")
	public String editResourceForNode(Model model, @PathVariable("id") Long id, HttpSession session) {
		session.setAttribute("node", id);
		List<Resource> resources = resourceService.findAllResources();
		List<NodesResources> nrs = nrService.findByNodesId(id);
		model.addAttribute("nodesResources", nrs);
		model.addAttribute("resources", resources);
		model.addAttribute("id", id);
		return "Admin/editResourceForNode.jsp";
	}
	
	@RequestMapping(value="/addToNode/{id}", method=RequestMethod.POST)
	public String addToNode(@PathVariable("id") Long id, HttpSession session) {
		Long nodeId = (Long) session.getAttribute("node");
		Resource resource = resourceService.findResourceById(id);
		Node node = nodeService.findNodeById(nodeId);
		NodesResources nr = new NodesResources(resource.getTitle());
		nr.setResource(resource);
		nr.setNode(node);
		nrService.createNR(nr);
		return "redirect:/admin/editResourceForNode/" + nodeId;
	}
	
	@RequestMapping("/updateNodesResources/{id}")
	public String updatNodesResources(@PathVariable("id") Long id, HttpSession session) {
		nrService.updateNodesResources(id);
		Long nodeId = (Long) session.getAttribute("node");
		return "redirect:/admin/editResourceForNode/" + nodeId;
	}
	
	@RequestMapping(value="/removeNodesResources/{id}", method=RequestMethod.DELETE)
	public String removeNodesResources(@PathVariable("id") Long id, HttpSession session) {
		Long nodeId = (Long) session.getAttribute("node");
		nrService.deleteNodesResources(id);
		return "redirect:/admin/editResourceForNode/" + nodeId;
	}
//	Resource Logic
	@RequestMapping("/createResource")
	public String createResource(@ModelAttribute("resource") Resource resource) {
		return "Admin/createResource.jsp";
	}
	
	@RequestMapping(value="/ingestNewResource", method=RequestMethod.POST)
	public String ingestNewResource(@Valid @ModelAttribute("resource") Resource newResource, BindingResult result) {
//		TODO Create Resource Validation
		resourceService.createResource(newResource);
		return "redirect:/admin/";
	}
	
	@RequestMapping("/editResource/{id}")
	public String editResource(Model model, @PathVariable("id") Long id, @ModelAttribute("updateResource") Resource updateResource) {
		Resource resource = resourceService.findResourceById(id);
		model.addAttribute("resource", resource);
		return "Admin/editResource.jsp";
	}
	
	@RequestMapping(value="/updateResource/{id}", method=RequestMethod.PUT)
	public String updateResource(@PathVariable("id") Long id, @ModelAttribute("updateResource") Resource resource) {
		resourceService.updateResource(id, resource);
		return "redirect:/admin/";
	}
	
	@RequestMapping(value="/deleteResource/{id}", method=RequestMethod.DELETE)
	public String deleteResource(@PathVariable("id") Long id) {
		resourceService.deleteResource(id);
		return "redirect:/admin/";
	}
}
