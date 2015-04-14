[1mdiff --git a/src/main/java/action/MapAction.java b/src/main/java/action/MapAction.java[m
[1mindex 94dc9d0..d0bb47b 100644[m
[1m--- a/src/main/java/action/MapAction.java[m
[1m+++ b/src/main/java/action/MapAction.java[m
[36m@@ -57,7 +57,7 @@[m [mpublic class MapAction extends ActionSupport{[m
 [m
 	public void insert(){[m
 		ObjectDaoImpl objectDao=new ObjectDaoImpl();[m
[31m-		ObjectMuseum object = new ObjectMuseum(new Integer(0),new Integer(3),"Livre","BELGIQUE","789898-78","livre representant...","Livre bis","20","30","89",null,new Date(),"Anvers",null,null);[m
[32m+[m		[32mObjectMuseum object = new ObjectMuseum(new Integer(0),new Integer(3),"Livre","Book","BELGIQUE","789898-78","livre representant...","Livre bis","20","30","89",null,new Date(),"Anvers",null,null);[m
 		objectDao.insert(object);[m
 	}[m
 [m
[1mdiff --git a/src/main/java/bdd/JDBC.java b/src/main/java/bdd/JDBC.java[m
[1mindex d408289..39cddf4 100644[m
[1m--- a/src/main/java/bdd/JDBC.java[m
[1m+++ b/src/main/java/bdd/JDBC.java[m
[36m@@ -61,7 +61,7 @@[m [mpublic class JDBC extends ActionSupport implements ServletRequestAware{[m
     	Session session = HibernateUtil.getSessionFactory().openSession();[m
     	 [m
         session.beginTransaction();[m
[31m-        ObjectMuseum object = new ObjectMuseum(new Integer(0),new Integer(3),"Livre","BELGIQUE","789898-78","livre representant...","Livre bis","20","30","89",null,new Date(),"Anvers",null,null);[m
[32m+[m[32m        ObjectMuseum object = new ObjectMuseum(new Integer(0),new Integer(3),"Livre","Book","BELGIQUE","789898-78","livre representant...","Livre bis","20","30","89",null,new Date(),"Anvers",null,null);[m
  [m
         session.save(object);[m
         session.getTransaction().commit();[m
[1mdiff --git a/src/main/java/mapping/ObjectMuseum.java b/src/main/java/mapping/ObjectMuseum.java[m
[1mindex cd50008..9b2fb60 100644[m
[1m--- a/src/main/java/mapping/ObjectMuseum.java[m
[1m+++ b/src/main/java/mapping/ObjectMuseum.java[m
[36m@@ -11,7 +11,8 @@[m [mpublic class ObjectMuseum implements java.io.Serializable {[m
  [m
 	private Integer id;[m
 	private Integer period_id;[m
[31m-	private String title;[m
[32m+[m	[32mprivate String title_f;[m
[32m+[m	[32mprivate String title_e;[m
 	private String country;[m
 	private String reference;[m
 	private String description_e;[m
[36m@@ -38,11 +39,17 @@[m [mpublic class ObjectMuseum implements java.io.Serializable {[m
 	public void setPeriod_id(Integer period_id) {[m
 		this.period_id = period_id;[m
 	}[m
[31m-	public String getTitle() {[m
[31m-		return title;[m
[32m+[m	[32mpublic String getTitle_f() {[m
[32m+[m		[32mreturn title_f;[m
 	}[m
[31m-	public void setTitle(String title) {[m
[31m-		this.title = title;[m
[32m+[m	[32mpublic void setTitle_f(String title_f) {[m
[32m+[m		[32mthis.title_f = title_f;[m
[32m+[m	[32m}[m
[32m+[m	[32mpublic String getTitle_e() {[m
[32m+[m		[32mreturn title_e;[m
[32m+[m	[32m}[m
[32m+[m	[32mpublic void setTitle_e(String title_e) {[m
[32m+[m		[32mthis.title_e = title_e;[m
 	}[m
 	public String getCountry() {[m
 		return country;[m
[36m@@ -116,14 +123,15 @@[m [mpublic class ObjectMuseum implements java.io.Serializable {[m
 	public void setLongitude(Double longitude) {[m
 		this.longitude = longitude;[m
 	}[m
[31m-	public ObjectMuseum(Integer id, Integer period_id, String title,[m
[32m+[m	[32mpublic ObjectMuseum(Integer id, Integer period_id, String title_f,String title_e,[m
 			String country, String reference, String description_e,[m
 			String description_f, String length, String heigth, String width,[m
 			String archeologist, Date date, String city, Double latitude,[m
 			Double longitude) {[m
 		this.id = id;[m
 		this.period_id = period_id;[m
[31m-		this.title = title;[m
[32m+[m		[32mthis.title_f = title_f;[m
[32m+[m		[32mthis.title_e = title_e;[m
 		this.country = country;[m
 		this.reference = reference;[m
 		this.description_e = description_e;[m
[1mdiff --git a/src/main/resources/hibernate.cfg.xml b/src/main/resources/hibernate.cfg.xml[m
[1mindex 933468d..b6b69cb 100644[m
[1m--- a/src/main/resources/hibernate.cfg.xml[m
[1m+++ b/src/main/resources/hibernate.cfg.xml[m
[36m@@ -6,7 +6,7 @@[m
     <session-factory>[m
         <property name="hibernate.bytecode.use_reflection_optimizer">false</property>[m
         <property name="hibernate.connection.driver_class">com.mysql.jdbc.Driver</property>[m
[31m-        <property name="hibernate.connection.password"></property>[m
[32m+[m[32m        <property name="hibernate.connection.password">noRA3126!</property>[m
         <property name="hibernate.connection.url">jdbc:mysql://localhost:3306/museum</property>[m
         <property name="hibernate.connection.username">root</property>[m
         <property name="hibernate.dialect">org.hibernate.dialect.MySQLDialect</property>[m
[1mdiff --git a/src/main/resources/table/Object.hbm.xml b/src/main/resources/table/Object.hbm.xml[m
[1mindex 74297e2..01b00de 100644[m
[1m--- a/src/main/resources/table/Object.hbm.xml[m
[1m+++ b/src/main/resources/table/Object.hbm.xml[m
[36m@@ -11,8 +11,11 @@[m
         <property name="period_id" type="java.lang.Integer">[m
             <column name="period_id" />[m
         </property>[m
[31m-        <property name="title" type="string">[m
[31m-            <column name="title" length="40" not-null="true"/>[m
[32m+[m[32m        <property name="title_f" type="string">[m
[32m+[m[32m            <column name="title_f" length="40" not-null="true"/>[m
[32m+[m[32m        </property>[m
[32m+[m[32m        <property name="title_e" type="string">[m
[32m+[m[32m            <column name="title_e" length="40" not-null="true"/>[m
         </property>[m
         <property name="country" type="string">[m
             <column name="country" length="40" not-null="true" />[m
[1mdiff --git a/src/main/webapp/carte.jsp b/src/main/webapp/carte.jsp[m
[1mindex 1a91376..66a929d 100644[m
[1m--- a/src/main/webapp/carte.jsp[m
[1m+++ b/src/main/webapp/carte.jsp[m
[36m@@ -114,14 +114,14 @@[m [minitialize = function(){[m
     var marker = new google.maps.Marker({[m
         position: myLatLng,[m
         map: map,[m
[31m-        title: 'Strasbourg'[m
[32m+[m[32m        title_f: 'Strasbourg'[m
     });[m
 [m
     var myLatLng2 = new google.maps.LatLng(47.218371,-1.553621);[m
     var marker2 = new google.maps.Marker({[m
         position: myLatLng2,[m
         map: map,[m
[31m-        title: 'Nantes'[m
[32m+[m[32m        title_f: 'Nantes'[m
     });[m
 [m
   [m
[1mdiff --git a/src/main/webapp/map.jsp b/src/main/webapp/map.jsp[m
[1mindex 0489318..dffeb59 100644[m
[1m--- a/src/main/webapp/map.jsp[m
[1m+++ b/src/main/webapp/map.jsp[m
[36m@@ -40,14 +40,14 @@[m [minitialize = function(){[m
     var marker = new google.maps.Marker({[m
         position: myLatLng,[m
         map: map,[m
[31m-        title: 'Strasbourg'[m
[32m+[m[32m        title_f: 'Strasbourg'[m
     });[m
 [m
     var myLatLng2 = new google.maps.LatLng(47.218371,-1.553621);[m
     var marker2 = new google.maps.Marker({[m
         position: myLatLng2,[m
         map: map,[m
[31m-        title: 'Nantes'[m
[32m+[m[32m        title_f: 'Nantes'[m
     });[m
 [m
   [m
[1mdiff --git a/target/classes/action/MapAction.class b/target/classes/action/MapAction.class[m
[1mindex 9e91896..ff0e1e5 100644[m
Binary files a/target/classes/action/MapAction.class and b/target/classes/action/MapAction.class differ
[1mdiff --git a/target/classes/bdd/ConnexionJDBC.class b/target/classes/bdd/ConnexionJDBC.class[m
[1mindex 813ff2b..8083728 100644[m
Binary files a/target/classes/bdd/ConnexionJDBC.class and b/target/classes/bdd/ConnexionJDBC.class differ
[1mdiff --git a/target/classes/bdd/JDBC.class b/target/classes/bdd/JDBC.class[m
[1mindex bc5a271..cb966cb 100644[m
Binary files a/target/classes/bdd/JDBC.class and b/target/classes/bdd/JDBC.class differ
[1mdiff --git a/target/classes/hibernate.cfg.xml b/target/classes/hibernate.cfg.xml[m
[1mindex 933468d..b6b69cb 100644[m
[1m--- a/target/classes/hibernate.cfg.xml[m
[1m+++ b/target/classes/hibernate.cfg.xml[m
[36m@@ -6,7 +6,7 @@[m
     <session-factory>[m
         <property name="hibernate.bytecode.use_reflection_optimizer">false</property>[m
         <property name="hibernate.connection.driver_class">com.mysql.jdbc.Driver</property>[m
[31m-        <property name="hibernate.connection.password"></property>[m
[32m+[m[32m        <property name="hibernate.connection.password">noRA3126!</property>[m
         <property name="hibernate.connection.url">jdbc:mysql://localhost:3306/museum</property>[m
         <property name="hibernate.connection.username">root</property>[m
         <property name="hibernate.dialect">org.hibernate.dialect.MySQLDialect</property>[m
[1mdiff --git a/target/classes/mapping/ObjectMuseum.class b/target/classes/mapping/ObjectMuseum.class[m
[1mindex d8816af..262e32b 100644[m
Binary files a/target/classes/mapping/ObjectMuseum.class and b/target/classes/mapping/ObjectMuseum.class differ
[1mdiff --git a/target/classes/table/Object.hbm.xml b/target/classes/table/Object.hbm.xml[m
[1mindex 74297e2..01b00de 100644[m
[1m--- a/target/classes/table/Object.hbm.xml[m
[1m+++ b/target/classes/table/Object.hbm.xml[m
[36m@@ -11,8 +11,11 @@[m
         <property name="period_id" type="java.lang.Integer">[m
             <column name="period_id" />[m
         </property>[m
[31m-        <property name="title" type="string">[m
[31m-            <column name="title" length="40" not-null="true"/>[m
[32m+[m[32m        <property name="title_f" type="string">[m
[32m+[m[32m            <column name="title_f" length="40" not-null="true"/>[m
[32m+[m[32m        </property>[m
[32m+[m[32m        <property name="title_e" type="string">[m
[32m+[m[32m            <column name="title_e" length="40" not-null="true"/>[m
         </property>[m
         <property name="country" type="string">[m
             <column name="country" length="40" not-null="true" />[m
[1mdiff --git a/target/m2e-wtp/web-resources/META-INF/MANIFEST.MF b/target/m2e-wtp/web-resources/META-INF/MANIFEST.MF[m
[1mindex 3fcdd72..4220a6a 100644[m
[1m--- a/target/m2e-wtp/web-resources/META-INF/MANIFEST.MF[m
[1m+++ b/target/m2e-wtp/web-resources/META-INF/MANIFEST.MF[m
[36m@@ -1,5 +1,5 @@[m
[31m-Manifest-Version: 1.0[m
[31m-Built-By: Roro7_000[m
[31m-Build-Jdk: 1.8.0_05[m
[31m-Created-By: Maven Integration for Eclipse[m
[31m-[m
[32m+[m[32mManifest-Version: 1.0[m[41m[m
[32m+[m[32mBuilt-By: amandine[m[41m[m
[32m+[m[32mBuild-Jdk: 1.8.0_31[m[41m[m
[32m+[m[32mCreated-By: Maven Integration for Eclipse[m[41m[m
[32m+[m[41m[m
[1mdiff --git a/target/m2e-wtp/web-resources/META-INF/maven/org.agafix/musee_catho/pom.properties b/target/m2e-wtp/web-resources/META-INF/maven/org.agafix/musee_catho/pom.properties[m
[1mindex 2c41046..0ac8647 100644[m
[1m--- a/target/m2e-wtp/web-resources/META-INF/maven/org.agafix/musee_catho/pom.properties[m
[1m+++ b/target/m2e-wtp/web-resources/META-INF/maven/org.agafix/musee_catho/pom.properties[m
[36m@@ -1,7 +1,7 @@[m
 #Generated by Maven Integration for Eclipse[m
[31m-#Mon Apr 13 13:24:02 CEST 2015[m
[32m+[m[32m#Mon Apr 13 20:10:51 CEST 2015[m
 version=1.0[m
 groupId=org.agafix[m
 m2e.projectName=projectGL[m
[31m-m2e.projectLocation=C\:\\Users\\Roro7_000\\workspace2\\projectGL[m
[32m+[m[32mm2e.projectLocation=/home/amandine/workspace/projectGL[m
 artifactId=musee_catho[m
