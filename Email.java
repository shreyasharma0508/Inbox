package labs.lab9;
import java.time.*;

public class Email implements Comparable{
	
	
	
	private String to;
	private String from;
	private String subject;
	private String content;
	private LocalDateTime time;
	private int priority;
	
	public Email(String to,String from,String subject, String content, int priority) {
		this.to = to;
		this.from = from;
		this.subject = subject;
		this.content = content;
		this.priority = priority;
		this.time = LocalDateTime.now();
	}
	
	public LocalDateTime getTime() {
		return time;
	}
	public String getTo() {
		return to;
		
	}
	
	public String getFrom() {
		return from;
		
	}
	
	public String getSubject() {
		return subject;
	}
	
	public String getContent() {
		return content;
	}
	
	public int getPriority() {
		return priority;
	}

	@Override
	public int compareTo(Object o) {
		Email other = (Email) o;
		if (this.priority<other.priority)
			return -1;
		else if (this.priority>other.priority)
			return 1;
		else 
			return 0;
	
		
	}
}