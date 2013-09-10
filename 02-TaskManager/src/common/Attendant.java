package common;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * non-active class. We could use this to change how the task manager's task- 
 * object is represented, i.e with attendants as a list instead of a string.
 * 
 * @author mi
 *
 */

public class Attendant {
	
	 @XmlAttribute
	 public String name;

}
