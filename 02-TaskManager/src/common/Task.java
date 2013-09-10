package common;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

public class Task {

	@XmlAttribute
	 public String id;
	 
	 @XmlAttribute
	 public String name;

	 @XmlAttribute
	 public String date;
	 
	 @XmlAttribute
	 public String status;
	 
	 @XmlAttribute
	 public String required;
	 
	 public String description;
	 
	 public String attendants; // We might want to make this a list instead
	 
}