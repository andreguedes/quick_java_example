import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.PriorityQueue;

enum EventPriority {

	PENDING(0, 2, null), 
	TRIED(1, 3, null), 
	DELIVERED(2, 5, null), 
	UNDELIVERED(3, 4, null), 
	DELIVERY_STARTED(4, 1, null);

	private int type;
	private int priority;
	private Calendar date;

	EventPriority(int type, int priority, Calendar date) {
		this.type = type;
		this.priority = priority;
		this.date = date;
	}

	public int getType() {
		return type;
	}

	public int getPriority() {
		return priority;
	}
	
	public Calendar getDate() {
		return date;
	}
}

class Event implements Comparable<Event> {
	
	String name;
	EventPriority priority;
	Calendar dateEvent;

	Event(String str, EventPriority pri, Calendar date) {
		name = str;
		priority = pri;
		dateEvent = date;
	}

	public int compareTo(Event event) {
		// 1 se o primeiro for maior que o segundo
		// 0 se for iguais, mantem a posicao
		// -1 se o primeiro for menor que o segundo.
		if (priority.getPriority() > event.priority.getPriority())
			return 1;
		else if (priority.getPriority() < event.priority.getPriority())
			return -1;
		else {
			if (dateEvent.before(event.dateEvent)) {
				return 1;
			}
			return -1;
		}
	}
}

public class PriorityQueueTest {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");	

	public static void main(String args[]) {

		PriorityQueue<Event> pq = new PriorityQueue<Event>(5);
		
		pq.add(new Event("Entrega 1", EventPriority.DELIVERED, new GregorianCalendar(2016, 1, 2, 8, 24, 56)));
		pq.add(new Event("Entrega 2", EventPriority.UNDELIVERED, new GregorianCalendar(2016, 1, 5, 8, 24, 56)));
		pq.add(new Event("Entrega 3", EventPriority.DELIVERED, new GregorianCalendar(2016, 1, 2, 8, 26, 56)));
		pq.add(new Event("Entrega 4", EventPriority.TRIED, new GregorianCalendar(2016, 1, 4, 8, 24, 56)));
		pq.add(new Event("Entrega 5", EventPriority.DELIVERY_STARTED, new GregorianCalendar(2016, 1, 6, 8, 50, 56)));
		pq.add(new Event("Entrega 6", EventPriority.DELIVERY_STARTED, new GregorianCalendar(2016, 1, 6, 8, 52, 56)));
		pq.add(new Event("Entrega 7", EventPriority.PENDING, new GregorianCalendar()));
		pq.add(new Event("Entrega 8", EventPriority.UNDELIVERED, new GregorianCalendar(2016, 1, 5, 8, 24, 59)));
		pq.add(new Event("Entrega 9", EventPriority.PENDING, new GregorianCalendar()));

		Event m;
		while ((m = pq.poll()) != null)
			System.out.println(m.name + " Priority: " + m.priority + ", Date: " + (m.dateEvent.getTime() != null ? sdf.format(m.dateEvent.getTime()) : "Sem data"));

	}

}