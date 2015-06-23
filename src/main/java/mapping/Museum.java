package mapping;

public class Museum implements java.io.Serializable {
	 
		private static final long serialVersionUID = 1L;
	 
		private Integer id;
		private String address;
		private String phone;
		private String mail;
		private String access;
		private String schedule;
		private String presentation_e;
		private String presentation_f;
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getMail() {
			return mail;
		}
		public void setMail(String mail) {
			this.mail = mail;
		}
		public String getAccess() {
			return access;
		}
		public void setAccess(String access) {
			this.access = access;
		}
		public String getSchedule() {
			return schedule;
		}
		public void setSchedule(String schedule) {
			this.schedule = schedule;
		}
		public String getPresentation_e() {
			return presentation_e;
		}
		public void setPresentation_e(String presentation_e) {
			this.presentation_e = presentation_e;
		}
		public String getPresentation_f() {
			return presentation_f;
		}
		public void setPresentation_f(String presentation_f) {
			this.presentation_f = presentation_f;
		}
		public Museum(Integer id, String address, String phone, String mail,
				String access, String schedule, String presentation_e,
				String presentation_f) {
			this.id = id;
			this.address = address;
			this.phone = phone;
			this.mail = mail;
			this.access = access;
			this.schedule = schedule;
			this.presentation_e = presentation_e;
			this.presentation_f = presentation_f;
		}
		public Museum() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
}