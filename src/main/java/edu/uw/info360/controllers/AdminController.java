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
import edu.uw.info360.models.PracticesNodes;
import edu.uw.info360.models.Resource;
import edu.uw.info360.services.NodeService;
import edu.uw.info360.services.NodesResourcesService;
import edu.uw.info360.services.PracticeService;
import edu.uw.info360.services.PracticesNodesService;
import edu.uw.info360.services.ResourceService;

@Controller
@RequestMapping("admin")
public class AdminController {
	private final PracticeService practiceService;
	private final NodeService nodeService;
	private final ResourceService resourceService;
	private final NodesResourcesService nrService;
	private final PracticesNodesService pnService;
	
	
	public AdminController( PracticeService practiceService,
							NodeService nodeService,
							ResourceService resourceService,
							NodesResourcesService nrService,
							PracticesNodesService pnService) {
		this.practiceService = practiceService;
		this.nodeService = nodeService;
		this.resourceService = resourceService;
		this.nrService = nrService;
		this.pnService = pnService;
	}

	@RequestMapping("")
	public String control(Model model) {
		List<Practice> practices = practiceService.findAllPractices();
		List<Node> nodes = nodeService.findAllNodes();
		List<Resource> resources = resourceService.findAllResources();
		model.addAttribute("resources", resources);
		model.addAttribute("nodes", nodes);
		model.addAttribute("practices", practices);
		return "Admin/control.jsp";
	}
//	Practice Logic
	@RequestMapping("/createPractice")
	public String createPractice(@ModelAttribute("practice") Practice practice) {
		return "Admin/createPractice.jsp";
	}
	
	@RequestMapping("/ingestNewPractice")
	public String ingestNewPractice(@Valid @ModelAttribute("practice") Practice newPractice, BindingResult result) {
		practiceService.addPractice(newPractice);
		return "redirect:/admin/";
	}
	
	@RequestMapping(value="/editPractice/{id}")
	public String editPractice(Model model, @PathVariable("id") Long id, @ModelAttribute("updatePractice") Practice updatePractice) {
		Practice practice = practiceService.findPracticeById(id);
		model.addAttribute("practice", practice);
		return "Admin/editPractice.jsp";
	}
	
	@RequestMapping(value="/updatePractice/{id}", method=RequestMethod.PUT)
	public String updatePractice(@PathVariable("id") Long id, @ModelAttribute("updatePractice") Practice practice) {
		practiceService.updatePractice(id, practice);
		return "redirect:/admin/";
	}
	
	@RequestMapping(value="/deletePractice/{id}", method=RequestMethod.DELETE)
	public String deletePractice(@PathVariable("id") Long id) {
		practiceService.deletePractice(id);
		return "redirect:/admin/";
	}
//	PracticesNodes Logic
	@RequestMapping("editNodeForPractice/{id}")
	public String editNodeForPractice(Model model, @PathVariable("id") Long id, HttpSession session) {
		session.setAttribute("practice", id);
		List<Node> nodes = nodeService.findAllNodes();
		List<PracticesNodes> pns = pnService.findByPracticesId(id);
		model.addAttribute("practicesNodes", pns);
		model.addAttribute("nodes", nodes);
		model.addAttribute("id", id);
		return "Admin/editNodeForPractice.jsp";
	}
	
	@RequestMapping(value="/addToPractice/{id}", method=RequestMethod.POST)
	public String addToPractice(@PathVariable("id") Long id, HttpSession session) {
		Long practiceId = (Long) session.getAttribute("practice");
		Node node = nodeService.findNodeById(id);
		Practice practice = practiceService.findPracticeById(practiceId);
		PracticesNodes pn = new PracticesNodes(node.getTitle());
		pn.setPractice(practice);
		pn.setNode(node);
		pnService.createPN(pn);
		return "redirect:/admin/editNodeForPractice/" + practiceId;
	}
	
	@RequestMapping("/updatePracticesNodes/{id}")
	public String updatePracticesNodes(@PathVariable("id") Long id, HttpSession session) {
		pnService.updatePracticesNodes(id);
		Long practiceId = (Long) session.getAttribute("practice");
		return "redirect:/admin/editNodeForPractice/" + practiceId;
	}
	
	@RequestMapping(value="/removePracticesNodes/{id}", method=RequestMethod.DELETE)
	public String removePracticesNodes(@PathVariable("id") Long id, HttpSession session) {
		Long practiceId = (Long) session.getAttribute("practice");
		pnService.deletePracticesNodes(id);
		return "redirect:/admin/editNodeForPractice/" + practiceId;
	}
	
//	Nodes Logic
	@RequestMapping("/createNode")
	public String createNode(@ModelAttribute("node") Node node) {
//		TODO: Capitalize first characters
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
