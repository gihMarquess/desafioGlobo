package br.com.globo.entidades;

public class Description {


		private String type;
		private Object content;
		
		public Description(){}
		
		public Description(String type, Object content){
			this.type = type;
			this.content = content;
		}
		
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public Object getContent() {
			return content;
		}
		public void setContent(Object content) {
			this.content = content;
		}
		
		@Override
		public String toString() {
			return "Type:" + this.type + "\nContent:" + this.content + "\n"; 
		}
}
