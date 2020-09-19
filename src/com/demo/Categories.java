package com.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sun.xml.internal.ws.api.pipe.NextAction;

public class Categories {
	private   int catalogId ;
	private  String catalogName ;
	private  int parentId;
	public int getCatalogId() {
		return catalogId;
	}
	public String getCatalogName() {
		return catalogName;
	}
	public int getParentId() {
		return parentId;
	}
	
	public void setCatalogId(int catalogId) {
		this.catalogId = catalogId;
	}
	public void setCatalogName(String catalogName) {
		this.catalogName = catalogName;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public Categories(int catalogId, String catalogName, int parentId) {
		super();
		this.catalogId = catalogId;
		this.catalogName = catalogName;
		this.parentId = parentId;
	}
	public Categories() {
		super();
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Categories> categories = new ArrayList<Categories>();
		do {
			
			System.out.println("bạn muốn nhập bao nhiêu danh mục");
			int select = sc.nextInt();
			for(int i =0 ; i< select ;i++) {
				categories.add(inputData());
			}
			
			display(categories);
		}while(true);
		
	}
	
	
	public static Categories inputData() {
		Categories categorie = new Categories();
		Scanner sc = new Scanner(System.in);
		System.out.println("nhập id");
		categorie.setCatalogId(Integer.parseInt(sc.nextLine()));
		System.out.println("nhập tên");
		categorie.setCatalogName(sc.nextLine());;
		System.out.println("nhập danh mục cha");
		categorie.setParentId(Integer.parseInt(sc.nextLine()));
		
		return categorie;
	}
	
	@Override
	public String toString() {
		return "Categories [catalogId=" + catalogId + ", catalogName=" + catalogName + ", parentId=" + parentId + "]";
	}
	public static void display(List<Categories> categories) {
		int index =0;
		int ind = 1;
		for(int i = 0 ; i<categories.size();i++) {
			if(categories.get(i).getParentId() != 0) break;
			System.out.println((i+1) +"."+ categories.get(i).getCatalogName());
			for(int j = 0; j < categories.size();j++) {
				if(categories.get(i).getCatalogId() == categories.get(j).getParentId()) {
						index++;
						System.out.println("\t"+(i+1)+"."+(index)+categories.get(j).getCatalogName());
						for(int k = 0;k<categories.size();k++) {
							if(categories.get(j).getCatalogId() == categories.get(k).getParentId()) {
								System.out.println("\t \t"+(i+1)+"."+(index)+"."+(ind)+categories.get(k).getCatalogName());
								ind++;
							}
						}
				}
			}
		}
		
	}
}
