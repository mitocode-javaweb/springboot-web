package com.mitocode.javaweb.mybatis.categoria.infraestructure.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mitocode.javaweb.mybatis.categoria.application.CategoriaFinderService;
import com.mitocode.javaweb.mybatis.categoria.infraestructure.dto.CategoriaDtoMapper;
import com.mitocode.javaweb.mybatis.shared.infraestructure.dto.CycleAvoidingMappingContext;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
@RequestMapping("/reportes/categorias")
public class ReporteCategoriaController {

	@Autowired
	private CategoriaFinderService categoriaFinderService;
	
	@Autowired
	private CategoriaDtoMapper categoriaDtoMapper;
	
	private static final String PATH = "src/main/resources/reportes";
	
	@ModelAttribute("modulo")
	public String modulo() {
		return "reportes";
	}

	@ModelAttribute("submodulo")
	public String submodulo() {
		return "categoria";
	}
	
	@GetMapping("/reporte01")
	public ResponseEntity<byte[]> reporte01(HttpServletResponse response, 
			@RequestParam(defaultValue = "inline") 
			String mode) throws JRException {
		
		JasperReport report = JasperCompileManager.compileReport(PATH + "/categoria-reporte.jrxml");
		report.setProperty("net.sf.jasperreports.awt.ignore.missing.font", "true");
		
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("NOMBRE_PROYECTO", "Java Web Developer");
		
		JRBeanCollectionDataSource source = new JRBeanCollectionDataSource(categoriaDtoMapper.toCategoriaDtos(categoriaFinderService.findAll(), new CycleAvoidingMappingContext()));
		
		JasperPrint print = JasperFillManager.fillReport(report, parameters, source);
		byte[] data = JasperExportManager.exportReportToPdf(print);
		
		if(!mode.equals("inline")) {
			mode = "attachment";
		}
		
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, mode + "; filename=categorias.pdf ")
				.contentType(MediaType.APPLICATION_PDF)
				.contentLength(data.length)
				.body(data);
	}
	
	
}
