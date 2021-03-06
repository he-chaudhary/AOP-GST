package com.axelor.gst.web;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//import javax.transaction.Transactional;

import com.axelor.app.AppSettings;
import com.axelor.data.Importer;
import com.axelor.data.csv.CSVImporter;
import com.axelor.dms.db.DMSFile;
import com.axelor.gst.db.Address;
import com.axelor.gst.db.City;
import com.axelor.gst.db.Company;
import com.axelor.gst.db.Contact;
import com.axelor.gst.db.Country;
import com.axelor.gst.db.Invoice;
import com.axelor.gst.db.InvoiceLine;
import com.axelor.gst.db.Party;
import com.axelor.gst.db.Product;
import com.axelor.gst.db.Sequence;
import com.axelor.gst.db.State;
import com.axelor.gst.db.repo.AddressRepository;
import com.axelor.gst.db.repo.CityRepository;
import com.axelor.gst.db.repo.CountryRepository;
import com.axelor.gst.db.repo.InvoiceLineRepository;
import com.axelor.gst.db.repo.InvoiceRepository;
import com.axelor.gst.db.repo.ProductRepository;
import com.axelor.gst.db.repo.SequenceRepository;
import com.axelor.gst.db.repo.StateRepository;
import com.axelor.gst.service.GstCalculation;
import com.axelor.inject.Beans;
import com.axelor.meta.CallMethod;
import com.axelor.meta.MetaFiles;
import com.axelor.meta.db.MetaModel;
import com.axelor.meta.db.repo.MetaModelRepository;
import com.axelor.rpc.ActionRequest;
import com.axelor.rpc.ActionResponse;
import com.axelor.rpc.Context;
//import com.google.common.io.Files;
import com.google.common.io.Resources;
import com.google.inject.Inject;
import com.google.inject.persist.Transactional;

public class InvoiceController {
	public void allGstCalculation(ActionRequest request, ActionResponse response) {

		Context context = request.getContext();
		
		InvoiceLine invoiceLine = context.asType(InvoiceLine.class);
		
		Invoice invoice = context.getParent().asType(Invoice.class);
		
		Address addressCompany = invoice.getCompany().getAddress();
//		String stateName = address.get
		
		Address addressInvoice = invoice.getInvoiceAddress();
		
		
		
		System.out.println("hello we are in all gst calculation" + invoiceLine.toString());
//		System.out.println("qty: "+qty+ " price"+price );
		
		GstCalculation gstCalculation = Beans.get(GstCalculation.class);
		if(addressInvoice.getState().equals(addressCompany.getState())) {
//			gstCalculation.
		}
		BigDecimal netAmount = gstCalculation.netAmountCalc(invoiceLine.getQty(),invoiceLine.getPrice());
		BigDecimal gstRate = invoiceLine.getGstRate();
//		if()
//		if() {
//			gstCalculation.igstCalc(netAmount,gstRate);
//			
//		}
		
	}
	
	  public void btnUpdater(ActionRequest request, ActionResponse response) {
	  Context context = request.getContext();
	  
	  Invoice invoice = context.asType(Invoice.class); response.setReload(true);
		/* response.setValue("statusContext", ); */
//	  response.setValue("statusContext", "draft");
//	  context.replace("statusConetxt", "draft");
//	  
//	  context.put("statusContext", "draft");
	  	
	  }
	 
	
//	public void cityData(ActionRequest request, ActionResponse response) {
//		Context context= request.getContext();
//		
//
//		Address address = context.asType(Address.class);
//		
////		if(address.getId() != null) {
////			address = Beans.get(AddressRepository.class).find(address.getId());
////		}
////		Address address = context.asType(Address.class);
////		
//		
//		//		 
//		
//		
//		City city = address.getCity();
//		
////	 		  if(city.getId() != null) { city = Beans.get(CityRepository.class).find(city.getId()); }
//	
//		
//		
//		System.out.println("hello in city: "+city.toString());
//		String cityName = city.getName();
//		String stateName= city.getState();
//		String countryName = city.getCountry();
//		
//		
////		Address address =context.getParent().asType(Address.class); 
//		
//		
//		State state = address.getState();
//		
//		if(state.getId() != null) {
//			state = Beans.get(StateRepository.class).find(state.getId());
//		}
//		
//		Country country = address.getCountry();
//		if(country.getId() != null) {
//			country = Beans.get(CountryRepository.class).find(country.getId());
//		}
//		
//		state.setName(stateName);
//		state.setCountry(countryName);
//		
//		
//		country.setName(countryName);
////		response.setValue("state", stateName);
////		response.setValue("country", countryName);
//				response.setValue("state",state);
//		response.setValue("country",country);
////		response.setValues(address);
//		
//		System.out.println(state.toString()+" : "+country.toString());
//
//		
////		response.setReload(true);
////		address.getState().setName(stateName);
////		System.out.println("state name after changes: "+address.getState());
////		
////		
////		System.out.println("r");
////		System.out.println(context.getClass());
////	
//////		response.setValue(state);
////	
////		
//////		System.out.println("response.getData: "+response.setV);
////		System.out.println("response.getclass: "+address.getState().toString());
////		State state = address.getState();
////		
//		
//	}
	
	/*
	 * public void statusValueProvider(ActionRequest request, ActionResponse
	 * response) { Context context = request.getContext();
	 * 
	 * Invoice invoice = context.asType(Invoice.class); int ans= 0;
	 * if(invoice.getId() != null) { invoice =
	 * Beans.get(InvoiceRepository.class).find(invoice.getId()); }
	 * System.out.println("hello we are in invoicecontroller "+invoice.getStatus());
	 * if(invoice.getStatus().equals("draft")) { System.out.println("draft: " );
	 * 
	 * ans = 1; } if(invoice.getStatus().equals("validated")) {
	 * System.out.println("validated: " ); ans = 2; }
	 * if(invoice.getStatus().equals("paid")) { System.out.println("paid: " ); ans =
	 * 3; } if(invoice.getStatus().equals("cancelled")) {
	 * System.out.println("cancelled: " ); ans = 4; }
	 * 
	 * response.setValue("statusValue", ans);
	 * 
	 * }
	 */	
	public void itemNameMaker(ActionRequest request, ActionResponse response) {
		
		Context context = request.getContext();
		
		InvoiceLine invoiceLine = context.asType(InvoiceLine.class);
		
		Product product = invoiceLine.getProduct();
		
		response.setValue("gstRate",product.getGstRate());
		
		String itemName ="["+product.getCode().toString()+"] "+product.getName().toString();
		System.out.println(itemName);
		response.setValue("item", itemName);
//		return itemName;
		
	
		
	}
	
	
	public void invoiceListCalc(ActionRequest request, ActionResponse response) {
		Context context = request.getContext();
		
		Invoice invoice = context.asType(Invoice.class);
		
//		if(invoice.getId() != null) {
//			invoice = Beans.get(InvoiceRepository.class).find(invoice.getId());
//		}
		
		BigDecimal netAmount = new BigDecimal("0.0");
		BigDecimal netIGST = new BigDecimal("0.0");
		BigDecimal netCGST = new BigDecimal("0.0");
		BigDecimal netSGST = new BigDecimal("0.0");
		BigDecimal grossAmount = new BigDecimal("0.0");
		System.out.println("hello we are in invoiceListCalc");
		List<InvoiceLine> invoiceItemList = invoice.getInvoiceItemsList();
		for(int i=0;i<invoiceItemList.size();i++) {
				System.out.println(invoiceItemList.get(i).getNetAmount()+" : "+ invoiceItemList.get(i).getIgst()+" : "+invoiceItemList.get(i).getCgst()+" : "+invoiceItemList.get(i).getSgst()+" : "+invoiceItemList.get(i).getGrossAmount());
				netAmount = netAmount.add( invoiceItemList.get(i).getNetAmount());
				netIGST = netIGST.add(invoiceItemList.get(i).getIgst());
				netCGST = netCGST.add(invoiceItemList.get(i).getCgst());
				netSGST = netSGST.add(invoiceItemList.get(i).getSgst());
				grossAmount = grossAmount.add(invoiceItemList.get(i).getGrossAmount());
				System.out.println("netAmount: "+netAmount+"\n netIGST: "+netIGST+" \n netCGST: "+netCGST+" \n netSGST: "+netSGST+" \n grossAmount: "+grossAmount);
		}
		System.out.println("netAmount: "+netAmount+"\n netIGST: "+netIGST+" \n netCGST: "+netCGST+" \n netSGST: "+netSGST+" \n grossAmount: "+grossAmount);
		response.setValue("netAmount",netAmount);
		response.setValue("netIGST", netIGST);
		response.setValue("netCGST", netSGST);
		response.setValue("grossAmount", grossAmount);
		
	}
	
	public void getFilePath(ActionRequest request, ActionResponse response) {
		Context context  = request.getContext();
		
		Invoice invoice = context.asType(Invoice.class);
		String path = AppSettings.get().get("file.upload.dir");
//		AppSettings app = context.asType(AppSettings.class);
//		AppSettings appObj = app.get();
//		String path = app.get("file.upload.dir");
		response.setValue("filePath", path);
		
		
	}
	
	@CallMethod
	public String getProductFilePath() {
		
		String locale = AppSettings.get().get("application.locale");
		System.out.println("locale value: "+locale);
		String path = AppSettings.get().get("file.upload.dir");
		System.out.println(path);
		return path;

		
	}
	
	@CallMethod
	public LocalDate getFromDate(LocalDate cdate) {
		
		return cdate.withDayOfMonth(1);

	}
	@Inject
	SequenceRepository seqRep ;
	
	@CallMethod
	@Transactional
	public String getSequenceString(String name) {
		
		
		MetaModel metaModel = Beans.get(MetaModelRepository.class).findByName(name);
		Sequence sequence = Beans.get(SequenceRepository.class).findByMetaModel(metaModel);
		if(sequence==null) {
			System.err.println("hello alert");
			
			return null ;
		}
		
		int padding = sequence.getPadding();
		String nextNumber = sequence.getNextNumber();
		String sequenceString = nextNumber;
		String suffix = sequence.getSuffix();
 		if (suffix == null) suffix="";
 		
 		
		System.out.println(suffix);
		String prefix = sequence.getPrefix();
		Integer pad = sequence.getPadding();
		int nu = getNumber(prefix,pad,nextNumber);
		nu++;
		nextNumber = getFirstNextNumber(prefix,suffix, pad, nu+"");
		System.out.println(nextNumber);
		sequence.setNextNumber(nextNumber);
		seqRep.save(sequence);

		return sequenceString;
		
		
	}
	
	
	public int getNumber(String prefix, int padding, String nextNumber) {
		boolean flag = false;
		String n = "";
		for(int i=prefix.length();i<prefix.length()+padding;i++) {
				
			if(flag) {
				
				n+= nextNumber.charAt(i);
				
			}else if(nextNumber.charAt(i) != '0' ) {
				n+=nextNumber.charAt(i);
				flag = true;
			}
		}
		return new Integer(n);
	}
	
	
	
	public void getNextNumber(ActionRequest request , ActionResponse response) {
		
		Context context = request.getContext();
		Sequence sequence = context.asType(Sequence.class);

		int paddingCustom = sequence.getPadding();
		String prefixCustom = sequence.getPrefix();
		String nextNumberCustom = sequence.getNextNumber();
		String suffixCustom  = sequence.getSuffix();
		
		if(suffixCustom== null) suffixCustom = "";
		
		
		if(sequence.getId() != null) {
			sequence = Beans.get(SequenceRepository.class).find(sequence.getId());
		}
		
		
		int padding = sequence.getPadding();
		String prefix = sequence.getPrefix();
		String nextNumber = sequence.getNextNumber();
		String suffix = sequence.getSuffix();
		
		if(suffix==null) suffix="";
		
		
		
		
		System.out.println(paddingCustom+" : "+prefixCustom+" : "+nextNumberCustom+" : "+suffixCustom);
		System.out.println(padding+" : "+prefix+" : "+nextNumber+" : "+suffix);
			
		String sequenceString = "";
		if(!prefix.equals(prefixCustom)) {
			sequenceString=prefixCustom;
				for(int i=prefix.length();i<nextNumber.length();i++) {
					sequenceString += nextNumber.charAt(i);
					
				}
				System.out.println(sequenceString);
		}else if(padding!=paddingCustom) {
			String n = getNumber(prefix,padding,nextNumber)+"";
			
			sequenceString = getFirstNextNumber(prefix,suffix, paddingCustom, n);
		}else {
			
			for(int i=0;i<nextNumber.length()-suffix.length();i++) {
				sequenceString += nextNumber.charAt(i);
			}
			sequenceString += suffixCustom;

		}
		
		response.setValue("nextNumber", sequenceString);
		
		
		
	}
	
	@CallMethod
	public String getFirstNextNumber(String prefix,String suffix, Integer padding, String n ) {
		String sequenceString = prefix;
		System.out.println("initial");
		for(int i=0;i<padding-n.length();i++) {
			sequenceString += "0";
		}
		sequenceString = sequenceString + n + suffix;
		
		return sequenceString;
		
	}
	
	
	public void setAddressContact(ActionRequest request, ActionResponse response) {
		System.out.println("we are in address contact");
		Context  context = request.getContext();
		
		Invoice invoice = context.asType(Invoice.class);
		
		Party party = invoice.getParty();
		
		List<Address> addressList = party.getAddressList();
		List<Contact> contactList = party.getContactList();
		
		
		
		
		Address defaultAdd = null;
		Address invoiceAdd = null;
		for(int i=0;i<addressList.size();i++) {
			if(addressList.get(i).getType().equals("invoice") ) {
				invoiceAdd = addressList.get(i);
			}else if(addressList.get(i).getType().equals("default")) {
				defaultAdd = addressList.get(i);
			}
		}
		invoiceAdd = (invoiceAdd==null) ? defaultAdd : invoiceAdd;
		response.setValue("invoiceAddress", invoiceAdd);
		
		
		Contact primaryContact = null;
		for(int i=0;i<contactList.size();i++) {
			if(contactList.get(i).getType().equals("primary")) {
				primaryContact = contactList.get(i);
			}
		}
		System.err.println(primaryContact.toString()+"hello"	);
		
		response.setValue("partyContact", primaryContact);
		
	}
	
	public void setShippingAddress(ActionRequest request, ActionResponse response) {
		
		Context  context = request.getContext();
		
		Invoice invoice = context.asType(Invoice.class);
		
		Party party = invoice.getParty();
		
		List<Address> addressList = party.getAddressList();
	
		
		Address defaultAdd = null;
		Address shippingAdd = null;
		for(int i=0;i<addressList.size();i++) {
			if(addressList.get(i).getType().equals("shipping") ) {
				shippingAdd = addressList.get(i);
			}else if(addressList.get(i).getType().equals("default")) {
				defaultAdd = addressList.get(i);
			}
		}
		shippingAdd = (shippingAdd==null) ? defaultAdd : shippingAdd;
		response.setValue("shippingAddress", shippingAdd);
		
		
		
	}
	
	@CallMethod
	public BigDecimal getProductPrice(Product product) {
		return product.getSalePrice();
	}
	@CallMethod
	public String getHSBNProduct(Product product) {
		return product.getHsbn();
	}
	
	
	public void getProductListfromProducts(ActionRequest request, ActionResponse response) {
		Context context = request.getContext();
		
		Invoice invoice = context.asType(Invoice.class);
////		System.out.println(context.);
//		System.out.println(request.getData().get("context")+"hello");
//		Map<String, List<Long>> a = (Map<String, List<Long>>) request.getData().get("context");
////		a.get
//		System.out.println(a.get("listOfProduct").get(0));
//	//	invoice.setInvoiceItemsList();
		
	}
	
//	public void getProductListFromIds()
		@CallMethod
	public List<InvoiceLine> getProductListFromIds(List<Integer> ids, Long id) {
		
		
		List<Product> productList  = new ArrayList<Product>();
		List<InvoiceLine> invoiceLineList = new ArrayList<InvoiceLine>();
		
		System.out.println("hello psdjsdlfj");
		for(int i=0;i<ids.size();i++) {
			InvoiceLine il = Beans.get(InvoiceLine.class);

			System.out.println(ids.get(i));
			Product product = Beans.get(ProductRepository.class).find((long)ids.get(i)); 
			il.setProduct(product);
			il.setHsbn(product.getHsbn());
			il.setItem(product.getName());
			il.setPrice(product.getSalePrice());
			il.setQty(1);
			il.setGstRate(product.getCategory().getGstRate());
			il.setItem("["+product.getCode()+"] "+product.getName());
			
			invoiceLineList.add(il);
			
	
		}
	
		
		return invoiceLineList;
	}

		
	public void dataImportProduct(ActionRequest request, ActionResponse response) throws IOException, URISyntaxException  {
		Context context = request.getContext();
		Invoice invoice = context.asType(Invoice.class);
//		System.err.println(getProductFilePath()+"hello guys") ;
//		invoice.getProductFileUpload().setFilePath();
		String path= AppSettings.get().get("file.upload.dir");
		
//		System.out.println("we are in "+Beans.get(MetaFiles.class).upload(new File("product.csv"),).getFilePath());
//		System.out.println(Paths.get("axelor-gst-app").toAbsolutePath());
//		Beans.get(MetaFiles.class).upload(new File("src/main/resources/product.csv"),invoice.getProductFileUpload());
//		
		Beans.get(InvoiceLineRepository.class).all().fetch().stream().forEach(invoiceLine -> {
			System.out.println(invoiceLine.getProduct() + " : "+
				invoiceLine.getInvoice() );
			
			
		});
		
		
		
		
		
		
		String xmlPath = Resources.getResource("data-demo/csv-multi-config.xml")+"";
		String csvPath= Resources.getResource("data-demo/input")+"";
		
		
		System.out.println(xmlPath.substring(9).split("/.metadata")[0]+" : "+csvPath.substring(9,csvPath.length()-1).split("/.metadata")[0]);
		
		Importer importer = new CSVImporter(xmlPath.substring(9).split("/.metadata")[0]+"/axelor-gst-app/modules/axelor-gst/src/main/resources/data-demo/csv-multi-config.xml",csvPath.substring(9).split("/.metadata")[0]+"/axelor-gst-app/modules/axelor-gst/src/main/resources/data-demo/input");
		importer.setContext(context);
		importer.run();
		System.err.println("this is importer");
		
		
		Beans.get(InvoiceLineRepository.class).all().fetch().stream().forEach(invoiceLine -> {
			System.out.println(invoiceLine.getProduct() + " : "+
				invoiceLine.getInvoice() );
			
			
		});
	}
	
}

























