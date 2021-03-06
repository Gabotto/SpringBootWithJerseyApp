/** 
 * SpringBootWithJerseyApp.
 * Copyright (C) 2017 Gabelopment (gabelopment@gmail.com)
 * 
 * This file is part of SpringBootWithJerseyApp.
 * 
 * SpringBootWithJerseyApp is only for test purpose:
 * you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * SpringBootWithJerseyApp is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with SpringBootWithJerseyApp. If not, see <http://www.gnu.org/licenses/>.
 *
 */
package com.example.sb.jersey.controller;

import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.example.sb.jersey.service.ExampleService;

/**
 * Handles the resource requests.
 * @author Gabriel
 *
 */
@Component
@Path("/resources")
public class ExampleController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExampleController.class);
	
	@Autowired
	private ExampleService exampleService;
	
	/**
	 * Gets a list of configured resources (queues and/or topics) for the application.
	 * @return
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	@Path("/get/test")
	public ResponseEntity<Map<String,String>> getConfiguredResources() {
		LOGGER.info("getConfiguredResources - start");
		
		Map<String,String> configuredResources = exampleService.getConfiguredResources();
		
		LOGGER.info("getConfiguredResources - end");
		return new ResponseEntity<Map<String,String>>(configuredResources, HttpStatus.OK);
	}
}
