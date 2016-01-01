package com.study;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExtractJars {
	
	private static List<String> jarNames = Arrays.asList("bpm-infra.jar",
			"bpm-services.jar",
			"fabric-runtime.jar",
			"jmxframework.jar",
			"jrf-api.jar",			
			"oracle-bpm.jar",
			"oracle.bpm.bpm-services.client.jar",
			"oracle.bpm.bpm-services.implementation.jar",
			"oracle.bpm.bpm-services.interface.jar",
			"oracle.bpm.bpm-services.internal.jar",
			"oracle.bpm.bpmobject.jar",
			"oracle.bpm.casemanagement.implementation.jar",
			"oracle.bpm.casemgmt.compositeutil.jar",
			"oracle.bpm.casemgmt.implementation.jar",
			"oracle.bpm.casemgmt.interface.jar",
			"oracle.bpm.client.jar",
			"oracle.bpm.connectors.jar",
			"oracle.bpm.core.jar",
			"oracle.bpm.diagram.draw.jar",
			"oracle.bpm.lib.jar",
			"oracle.bpm.metadata-interface.jar",
			"oracle.bpm.metadata.jar",
			"oracle.bpm.obpi.papi-ora.jar",
			"oracle.bpm.papi.jar",
			"oracle.bpm.project.catalog.jar",
			"oracle.bpm.project.compile.jar",
			"oracle.bpm.project.draw.jar",
			"oracle.bpm.project.io.jar",
			"oracle.bpm.project.jar",
			"oracle.bpm.project.model.jar",
			"oracle.bpm.project.ui.jar",
			"oracle.bpm.rmi.jar",
			"oracle.bpm.runtime.jar",
			"oracle.bpm.vfilesystem.jar",
			"oracle.bpm.web-resources.jar",
			"oracle.bpm.web.execution.jar",
			"oracle.bpm.workspace.jar",
			"oracle.bpm.xml.jar",
			"soa-infra-mgmt.jar",
			"wlfullclient.jar",
			"wsclient_extended.jar",
			"xmlparserv2.jar");
	private static List<String> copiedJars = new ArrayList<String>();
	
	public static void main(String[] args) throws IOException {
		//Path to main installation folder. 
		File mainDir = new File("C:\\Users\\924699\\Documents\\10-31-14\\modules_11.1.17.4\\modules");
		File newDir = new File("C:\\Users\\924699\\Documents\\10-31-14\\modules_11.1.17.4\\modules\\newJars");
		if(!newDir.exists()){
			newDir.mkdir();
		}
		copy(mainDir);
		System.out.println("Missing Jars");
		for(String actulFilename:jarNames){
			
			if(!copiedJars.contains(actulFilename)){
				System.out.println(actulFilename);
			}
		}
		
	}
	
	private static void copy(File mainDir) throws IOException{
		if(mainDir.isDirectory()){
			File[] fileNames = mainDir.listFiles();
			for(File fileName:fileNames){
				if(fileName.isDirectory()){
					copy(fileName);
				}else
				if(jarNames.contains(fileName.getName())){
					System.out.println(fileName.getAbsolutePath().replace("C:\\Users\\924699\\Documents\\10-31-14\\modules_11.1.17.4", ""));
					
//					FileChannel source = null;
//					FileChannel destination = null;
//					source = new FileInputStream(fileName.getAbsolutePath()).getChannel();
//					destination = new FileOutputStream("C:\\Users\\924699\\Documents\\10-31-14\\modules_11.1.17.4\\modules\\newJars\\"+fileName.getName()).getChannel();
//					if (destination != null && source != null) {
//						destination.transferFrom(source, 0, source.size());
//					}
//					if (source != null) {
//						source.close();
//					}
//					if (destination != null) {
//						destination.close();
//					}
					copiedJars.add(fileName.getName());
					
				}
			}
		}
	}

}
