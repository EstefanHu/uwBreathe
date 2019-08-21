package edu.uw.breathe.controllers;

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

import edu.uw.breathe.models.Node;
import edu.uw.breathe.models.NodesPractices;
import edu.uw.breathe.models.NodesResources;
import edu.uw.breathe.models.Practice;
import edu.uw.breathe.models.Resource;
import edu.uw.breathe.services.NodeService;
import edu.uw.breathe.services.NodesPracticesService;
import edu.uw.breathe.services.NodesResourcesService;
import edu.uw.breathe.services.PracticeService;
import edu.uw.breathe.services.ResourceService;

@Controller
@RequestMapping("admin")
public class AdminController {
	private final PracticeService practiceService;
	private final NodeService nodeService;
	private final ResourceService resourceService;
	private final NodesResourcesService nrService;
	private final NodesPracticesService npService;
	
	
	public AdminController( PracticeService practiceService,
							NodeService nodeService,
							ResourceService resourceService,
							NodesResourcesService nrService,
							NodesPracticesService npService) {
		this.practiceService = practiceService;
		this.nodeService = nodeService;
		this.resourceService = resourceService;
		this.nrService = nrService;
		this.npService = npService;
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
	@RequestMapping("/node")
	public String node(Model model, @ModelAttribute("createNode") Node createNode) {
		List<Node> nodes = nodeService.findAllNodes();
		model.addAttribute("nodes", nodes);
		return "Admin/node.jsp";
	}
	@RequestMapping("/node/{id}")
	public String node(Model model, @PathVariable("id") Long id,@ModelAttribute("createNode") Node createNode, HttpSession session) {
		session.setAttribute("nodeId", id);
		List<Practice> practices = practiceService.findAllPractices();
		List<Node> nodes = nodeService.findAllNodes();
		Node node = nodeService.findNodeById(id);
		List<Resource> resources = resourceService.findAllResources();
		List<NodesPractices> nps = npService.findByNodesId(id);
		model.addAttribute("nodesPractices", nps);
		model.addAttribute("resources", resources);
		model.addAttribute("nodes", nodes);
		model.addAttribute("node", node);
		model.addAttribute("updateNode", node);
		model.addAttribute("practices", practices);
		return "Admin/node.jsp";
	}
//	Nodes Logic
	@RequestMapping("/createNode")
	public String createNode(@ModelAttribute("node") Node node) {
//		TODO: Capitalize first characters
		return "Admin/createNode.jsp";
	}
	
	@RequestMapping(value="/createNewNode", method=RequestMethod.POST)
	public String createNewNode(@Valid @ModelAttribute("newNode") Node newNode, BindingResult result, HttpSession session) {
//		TODO: Create Node Validation
		Long nodeId = (Long) session.getAttribute("nodeId");
		nodeService.createNode(newNode);
		return "redirect:/admin/node";
	}
	
	@RequestMapping("/editNode/{id}")
	public String editNode(Model model, @PathVariable("id") Long id, @ModelAttribute("updateNode") Node updateNode) {
		Node node = nodeService.findNodeById(id);
		model.addAttribute("node", node);
		return "Admin/editNode.jsp";
	}
	
	@RequestMapping(value="/updateNode/{id}", method=RequestMethod.PUT)
	public String updateNode(@PathVariable("id") Long id, @ModelAttribute("updateNode") Node node, HttpSession session) {
		Long nodeId = (Long)session.getAttribute("nodeId");
		nodeService.updateNode(id, node);
		return "redirect:/admin/node/"+ nodeId;
	}
	
	@RequestMapping(value="/deleteNode/{id}", method=RequestMethod.DELETE)
	public String deleteNode(@PathVariable("id") Long id) {
		nodeService.deleteNode(id);
		return "redirect:/admin/node";
	}
//	Manage Node Relationship Logic
	@RequestMapping("manageNodeRelationships/{id}")
	public String manageNodeRelationships(Model model, @PathVariable("id") Long id, HttpSession session) {
		session.setAttribute("node", id);
		List<Practice> practices = practiceService.findAllPractices();
		List<Resource> resources = resourceService.findAllResources();
		List<NodesPractices> nps = npService.findByNodesId(id);
		List<NodesResources> nrs = nrService.findByNodesId(id);
		model.addAttribute("nodesPractices", nps);
		model.addAttribute("practices", practices);
		model.addAttribute("nodesResources", nrs);
		model.addAttribute("resources", resources);
		model.addAttribute("id", id);
		return "Admin/manageNodeRelationships.jsp";
	}
//	Managing Practices Logic
	@RequestMapping(value="/addPracticeToNode/{id}", method=RequestMethod.POST)
	public String addPracticeToNode(@PathVariable("id") Long id, HttpSession session) {
		Long nodeId = (Long) session.getAttribute("node");
		Node node = nodeService.findNodeById(nodeId);
		Practice practice = practiceService.findPracticeById(id);
		node.addPractice(practice);
		NodesPractices np = new NodesPractices(practice.getTitle());
		np.setPractice(practice);
		np.setNode(node);
		npService.createNP(np);
		return "redirect:/admin/manageNodeRelationships/" + nodeId;
	}
	
	@RequestMapping("/updateNodesPractices/{id}")
	public String updateNodesPractices(@PathVariable("id") Long id, HttpSession session) {
		npService.updateNodesPractices(id);
		Long nodeId = (Long) session.getAttribute("node");
		return "redirect:/admin/manageNodeRelationships/" + nodeId;
	}
	
	@RequestMapping(value="/removeNodesPractices/{id}", method=RequestMethod.DELETE)
	public String removeNodesPractices(@PathVariable("id") Long id, HttpSession session) {
		Long nodeId = (Long) session.getAttribute("node");
		npService.deleteNodesPractices(id);
		return "redirect:/admin/manageNodeRelationships/" + nodeId;
	}
//	Managing Resources Logic
	@RequestMapping(value="/addResourceToNode/{id}", method=RequestMethod.POST)
	public String addResourceToNode(@PathVariable("id") Long id, HttpSession session) {
		Long nodeId = (Long) session.getAttribute("node");
		Resource resource = resourceService.findResourceById(id);
		Node node = nodeService.findNodeById(nodeId);
		NodesResources nr = new NodesResources(resource.getTitle());
		nr.setResource(resource);
		nr.setNode(node);
		nrService.createNR(nr);
		return "redirect:/admin/manageNodeRelationships/" + nodeId;
	}
	
	@RequestMapping("/updateNodesResources/{id}")
	public String updatNodesResources(@PathVariable("id") Long id, HttpSession session) {
		nrService.updateNodesResources(id);
		Long nodeId = (Long) session.getAttribute("node");
		return "redirect:/admin/manageNodeRelationships/" + nodeId;
	}
	
	@RequestMapping(value="/removeNodesResources/{id}", method=RequestMethod.DELETE)
	public String removeNodesResources(@PathVariable("id") Long id, HttpSession session) {
		Long nodeId = (Long) session.getAttribute("node");
		nrService.deleteNodesResources(id);
		return "redirect:/admin/manageNodeRelationships/" + nodeId;
	}
//	Practice Logic
	@RequestMapping("/practice")
	public String practice(Model model, @ModelAttribute("createPractice") Practice practice) {
		List<Practice> practices = practiceService.findAllPractices();
		model.addAttribute("practices", practices);
		return "Admin/restPractice.jsp";
	}
	@RequestMapping("/practice/{id}")
	public String practice(Model model, @PathVariable("id") Long id, @ModelAttribute("createPractice") Practice createPractice, 
			HttpSession session) {
		session.setAttribute("practiceId", id);
		List<Practice> practices = practiceService.findAllPractices();
		List<Node> nodes = nodeService.findAllNodes();
		Practice practice = practiceService.findPracticeById(id);
		List<NodesPractices> nps = npService.findByNodesId(id);
		model.addAttribute("nodesPractices", nps);
		model.addAttribute("nodes", nodes);
		model.addAttribute("practices", practices);
		model.addAttribute("practice", practice);
		model.addAttribute("updatePractice", practice);
		return "Admin/restPractice.jsp";
	}
	
	@RequestMapping("/createPractice")
	public String createPractice(@ModelAttribute("practice") Practice practice) {
		return "Admin/createPractice.jsp";
	}
	
	@RequestMapping("/createNewPractice")
	public String createNewPractice(@Valid @ModelAttribute("newPractice") Practice newPractice, BindingResult result,
			HttpSession sessions) {
		Long practiceId = (Long)sessions.getAttribute("practiceId");
		practiceService.addPractice(newPractice);
		return "redirect:/admin/restPractice/";
	}
	
	@RequestMapping(value="/editPractice/{id}")
	public String editPractice(Model model, @PathVariable("id") Long id, @ModelAttribute("updatePractice") Practice updatePractice) {
		Practice practice = practiceService.findPracticeById(id);
		model.addAttribute("practice", practice);
		return "Admin/editPractice.jsp";
	}
	
	@RequestMapping(value="/updatePractice/{id}", method=RequestMethod.PUT)
	public String updatePractice(@PathVariable("id") Long id, @ModelAttribute("updatePractice") Practice practice,
			HttpSession sessions) {
		Long practiceId = (Long)sessions.getAttribute("practiceId");
		practiceService.updatePractice(id, practice);
		return "redirect:/admin/restPractice/" + practiceId;
	}
	
	@RequestMapping(value="/deletePractice/{id}", method=RequestMethod.DELETE)
	public String deletePractice(@PathVariable("id") Long id) {
		practiceService.deletePractice(id);
		return "redirect:/admin/practice";
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
