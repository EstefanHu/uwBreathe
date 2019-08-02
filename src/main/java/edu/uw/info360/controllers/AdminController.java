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
import edu.uw.info360.models.Path;
import edu.uw.info360.models.PathsNodes;
import edu.uw.info360.models.Resource;
import edu.uw.info360.services.NodeService;
import edu.uw.info360.services.NodesResourcesService;
import edu.uw.info360.services.PathService;
import edu.uw.info360.services.PathsNodesService;
import edu.uw.info360.services.ResourceService;
import edu.uw.info360.validators.PathValidator;

@Controller
@RequestMapping("admin")
public class AdminController {
	private final PathService pathService;
	private final NodeService nodeService;
	private final ResourceService resourceService;
	private final PathsNodesService pnService;
	private final NodesResourcesService nrService;
	
	private final PathValidator pathValidator;
	
	public AdminController(PathService pathService, PathValidator pathValidator, 
														NodeService nodeService,
														ResourceService resourceService,
														PathsNodesService pnService,
														NodesResourcesService nrService) {
		this.pathService = pathService;
		this.pathValidator = pathValidator;
		this.nodeService = nodeService;
		this.resourceService = resourceService;
		this.pnService = pnService;
		this.nrService = nrService;
	}
	@RequestMapping("")
	public String control(Model model) {
		List<Path> paths = pathService.findAllPaths();
		List<Node> nodes = nodeService.findAllNodes();
		List<Resource> resources = resourceService.findAllResources();
		model.addAttribute("resources", resources);
		model.addAttribute("nodes", nodes);
		model.addAttribute("paths", paths);
		return "Admin/control.jsp";
	}
	
	@RequestMapping("/createPath")
	public String createPath(@ModelAttribute("path") Path path) {
		return "Admin/createPath.jsp";
	}
	
	@RequestMapping(value="/ingestNewPath", method=RequestMethod.POST)
	public String ingestNewPath(@Valid @ModelAttribute("path") Path newPath, BindingResult result) {
		pathValidator.validate(newPath, result);
		if(result.hasErrors()) {
			return "Admin/createPath.jsp";
		}
		pathService.createPath(newPath);
		return "redirect:/admin/";
	}
	
	@RequestMapping("/editPath/{id}")
	public String editPath(Model model, @PathVariable("id") Long id, @ModelAttribute("updatePath") Path updatePath) {
		Path path = pathService.findPathById(id);
		model.addAttribute("path", path);
		return "Admin/editPath.jsp";
	}
	
	@RequestMapping(value="/updatePath/{id}", method=RequestMethod.PUT)
	public String updatePath(@PathVariable("id") Long id, @ModelAttribute("updatePath") Path path) {
		pathService.updatePath(id, path);
		return "redirect:/admin/";
	}
	
	@RequestMapping(value="/deletePath/{id}", method=RequestMethod.DELETE)
	public String deletePath(@PathVariable("id") Long id) {
		pathService.deletePath(id);
		return "redirect:/admin/";
	}
	
	@RequestMapping("/editNodeForPath/{id}")
	public String editNodeForPath(Model model, @PathVariable("id") Long id, HttpSession session) {
		session.setAttribute("path", id);
		List<Node> nodes = nodeService.findAllNodes();
		List<PathsNodes> pns = pnService.findByPathsId(id);
		model.addAttribute("pathsNodes", pns);
		model.addAttribute("nodes", nodes);
		model.addAttribute("id", id);
		return "Admin/editNodeForPath.jsp";
	}
	
	@RequestMapping(value="/addToPath/{id}", method=RequestMethod.POST)
	public String addToPath(@PathVariable("id") Long id, HttpSession session) {
		Long pathId = (Long) session.getAttribute("path");
		Node node = nodeService.findNodeById(id);
		Path path = pathService.findPathById(pathId);
		PathsNodes pn = new PathsNodes(node.getTitle());
		pn.setNode(node);
		pn.setPath(path);
		pnService.createPN(pn);
		return "redirect:/admin/editNodeForPath/" + pathId;
	}
	
	@RequestMapping("/updatePathsNodes/{id}")
	public String updatePathsNodes(@PathVariable("id") Long id, HttpSession session) {
		pnService.updatePathsNodes(id);
		Long pathId = (Long) session.getAttribute("path");
		return "redirect:/admin/editNodeForPath/" + pathId;
	}
	
	@RequestMapping(value="/removePathsNodes/{id}", method=RequestMethod.DELETE)
	public String removePathsNodes(@PathVariable("id") Long id, HttpSession session) {
		Long pathId = (Long) session.getAttribute("path");
		pnService.deletePathsNodes(id);
		return "redirect:/admin/editNodeForPath/" + pathId;
	}
	
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
