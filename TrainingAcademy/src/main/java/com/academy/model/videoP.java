package com.academy.model;

public class videoP {
	    String id;
	    String title;
	    String link;
	    String category;
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getLink() {
			return link;
		}
		public void setLink(String link) {
			this.link = link;
		}
		public String getCategory() {
			return category;
		}
		public videoP(String id, String title, String link, String category) {
			super();
			this.id = id;
			this.title = title;
			this.link = link;
			this.category = category;
		}
		public videoP() {
			// TODO Auto-generated constructor stub
		}
		public void setCategory(String category) {
			this.category = category;
		}
		
}
