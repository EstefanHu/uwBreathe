package edu.uw.breathe.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.uw.breathe.models.Node;
import edu.uw.breathe.models.NodesPractices;
import edu.uw.breathe.models.Practice;
import edu.uw.breathe.services.NodeService;
import edu.uw.breathe.services.NodesPracticesService;
import edu.uw.breathe.services.PracticeService;

@Controller
@RequestMapping("admin")
public class AdminController {
	private final PracticeService practiceService;
	private final NodeService nodeService;
	private final NodesPracticesService npService;
	
	
	public AdminController( PracticeService practiceService,
							NodeService nodeService,
							NodesPracticesService npService) {
		this.practiceService = practiceService;
		this.nodeService = nodeService;
		this.npService = npService;
	}

	@RequestMapping("")
	public String control(Model model) {
		List<Practice> practices = practiceService.findAllPractices();
		List<Node> nodes = nodeService.findAllNodes();
		model.addAttribute("nodes", nodes);
		model.addAttribute("practices", practices);
		return "Admin/statistics.jsp";
	}
// Node Logic
	@RequestMapping("/node")
	public String node(Model model) {
		List<Node> nodes = nodeService.findAllNodes();
		model.addAttribute("nodes", nodes);
		return "Admin/node.jsp";
	}
	
	@RequestMapping("/node/{id}")
	public String node(Model model, @PathVariable("id") Long id, HttpSession session) {
		session.setAttribute("nodeId", id);
		List<Practice> practices = practiceService.findAllPractices();
		List<Node> nodes = nodeService.findAllNodes();
		Node node = nodeService.findNodeById(id);
		List<NodesPractices> nps = npService.findByNodesId(id);
		model.addAttribute("nodesPractices", nps);
		model.addAttribute("nodes", nodes);
		model.addAttribute("currentNode", node);
		model.addAttribute("updateNode", node);
		model.addAttribute("practices", practices);
		return "Admin/node.jsp";
	}
	
	@RequestMapping("/createNode")
	public String createNode(Model model, @ModelAttribute("createNode") Node createNode) {
		List<Node> nodes = nodeService.findAllNodes();
		model.addAttribute("nodes", nodes);
		return "Admin/node.jsp";
	}

	@RequestMapping(value="/createNewNode", method=RequestMethod.POST)
	public String createNewNode(@Valid @ModelAttribute("newNode") Node newNode) {
		nodeService.createNode(newNode);
		return "redirect:/admin/node";
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
//	Managing Practices Logic
	@RequestMapping("/addPracticeToNode/{id}")
	public String addPracticeToNode(@PathVariable("id") Long id, HttpSession session) {
		Long nodeId = (Long) session.getAttribute("nodeId");
		Node node = nodeService.findNodeById(nodeId);
		Practice practice = practiceService.findPracticeById(id);
		node.addPractice(practice);
		NodesPractices np = new NodesPractices(practice.getTitle());
		np.setPractice(practice);
		np.setNode(node);
		npService.createNP(np);
		return "redirect:/admin/node/" + nodeId;
	}
	
	@RequestMapping("/updateNodesPractices/{id}")
	public String updateNodesPractices(@PathVariable("id") Long id, HttpSession session) {
		npService.updateNodesPractices(id);
		Long nodeId = (Long) session.getAttribute("nodeId");
		return "redirect:/admin/node/" + nodeId;
	}
	
	@RequestMapping("/removeNodesPractices/{id}")
	public String removeNodesPractices(@PathVariable("id") Long id, HttpSession session) {
		Long nodeId = (Long) session.getAttribute("nodeId");
		npService.deleteNodesPractices(id);
		return "redirect:/admin/node/" + nodeId;
	}
//	Practice Logic
	@RequestMapping("/practice")
	public String practice(Model model, @ModelAttribute("createPractice") Practice practice) {
		List<Practice> practices = practiceService.findAllPractices();
		model.addAttribute("practices", practices);
		return "Admin/practice.jsp";
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
		return "Admin/practice.jsp";
	}
	
	@RequestMapping("/createNewPractice")
	public String createNewPractice(@Valid @ModelAttribute("newPractice") Practice newPractice, HttpSession sessions) {
		practiceService.addPractice(newPractice);
		return "redirect:/admin/practice/";
	}
	
	@RequestMapping(value="/updatePractice/{id}", method=RequestMethod.PUT)
	public String updatePractice(@PathVariable("id") Long id, @ModelAttribute("updatePractice") Practice practice,
			HttpSession sessions) {
		Long practiceId = (Long)sessions.getAttribute("practiceId");
		practiceService.updatePractice(id, practice);
		return "redirect:/admin/practice/" + practiceId;
	}
	
	@RequestMapping(value="/deletePractice/{id}", method=RequestMethod.DELETE)
	public String deletePractice(@PathVariable("id") Long id) {
		practiceService.deletePractice(id);
		return "redirect:/admin/practice";
	}
}
