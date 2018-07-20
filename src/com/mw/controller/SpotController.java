package com.mw.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mw.frame.Service;
import com.mw.service.SpotService;
import com.mw.vo.Comment;
import com.mw.vo.Lnglat;
import com.mw.vo.Spot;

@Controller
public class SpotController {
	
	@Resource(name="iservice")
	Service<Spot, String> service;
	
	@Resource(name="iservice")
	SpotService sservice;
	
	@RequestMapping("/addspot.mw")
	public ModelAndView addspot() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		mv.addObject("centerpage", "spot/add");
		return mv; // Spot/add.jsp
	}
	
	@RequestMapping("/getspots.mw")
	public void getspots(HttpServletRequest request, HttpServletResponse response)  {
		double startLng = Double.parseDouble(request.getParameter("nelng"));
		double startLat = Double.parseDouble(request.getParameter("nelat"));
		double endLng = Double.parseDouble(request.getParameter("swlng"));
		double endLat = Double.parseDouble(request.getParameter("swlat"));
		
		
		JSONArray ja = new JSONArray();
	    
		try {

			List<Spot> spots = sservice.getByLnglat(new Lnglat(startLng,startLat,endLng,endLat));
						
			for(Spot spot : spots) {
				JSONObject jo = new JSONObject();
			    jo.put("name", "a_value");
			    jo.put("lng", 235.1252);
			    jo.put("lat", 235.1252);
			    jo.put("category", "c_value");
			    ja.add(jo);	
			}
		    
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			    
	    try {
	    	response.setContentType("text/json; charset=EUC-KR");
			PrintWriter writer = response.getWriter(); 
			writer.print(ja);
	    } catch (IOException e) {
	        e.printStackTrace();
	    } 
	}
	
	@RequestMapping("/deletespot.mw")
	public ModelAndView delspot() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		mv.addObject("centerpage", "spot/add");
		return mv; // Spot/add.jsp
	}
	

	
}