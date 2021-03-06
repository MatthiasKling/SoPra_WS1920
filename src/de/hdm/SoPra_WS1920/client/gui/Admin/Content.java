package de.hdm.SoPra_WS1920.client.gui.Admin;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Vector;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.datepicker.client.DatePicker;

import de.hdm.SoPra_WS1920.client.ClientsideSettings;
import de.hdm.SoPra_WS1920.shared.CinemaAdministrationAsync;
import de.hdm.SoPra_WS1920.shared.bo.Cinema;
import de.hdm.SoPra_WS1920.shared.bo.CinemaChain;
import de.hdm.SoPra_WS1920.shared.bo.Movie;
import de.hdm.SoPra_WS1920.shared.bo.Person;
import de.hdm.SoPra_WS1920.shared.bo.Screening;

public class Content extends FlowPanel{
	
	Cinema c;
	Screening s;
	Movie m;
	DatePicker dP;
	Header h;
	Button b;
	DateBox dB;
	TextBox textBox;
	SuggestBox box;
	Person user;
	
	CinemaAdministrationAsync cinemaAdministration;
	
	public Content() {
	}
	
	@SuppressWarnings("deprecation")
	public void onLoad() {
		super.onLoad();
		this.setStyleName("content");
		cinemaAdministration = ClientsideSettings.getCinemaAdministration();
//		dP = new DatePicker();
//		this.add(dP);
		
		//Example Objects for testing the GUI. Those objects will be deleted as soon as the backend is attached to the frontend
		user = new Person();
		user.setEMail("sebi.hermann95@t-online.de");
		user.setFirstname("Sebastian");
		user.setLastname("Hermann");
		user.setId(1);
		
//		c = new Cinema();
//		c.setName("Cinemax");
//		c.setCity("Stuttgart");
//		c.setZipCode("70372");
//		c.setPersonFK(1);
//		c.setStreet("Deckerstra�e");
//		c.setStreetNo("49");
//		c.setId(1);
//		
//		m = new Movie();
//		m.setName("Joker");
//		m.setGenre("Drama");
//		m.setDescription("Forever alone in a crowd, failed comedian Arthur Fleck seeks connection "
//				+ "as he walks the streets of Gotham City. Arthur wears two masks -- the one he "
//				+ "paints for his day job as a clown, and the guise he projects in a futile attempt "
//				+ "to feel like he's part of the world around him.");
//		m.setId(1);
//		
//		s=new Screening();
//		s = new Screening();
//		s.setCinemaFK(c.getId());
//		s.setMovieFK(m.getId());
//		s.setPersonFK(1);
//		Date d = (Date) DateTimeFormat.getFormat("dd.MM.yyyy").parse("31.12.2019");
//		s.setScreeningDate(d);
//		Time t = new Time(DateTimeFormat.getFormat("hh:mm").parse("02:30").getTime());
//		s.setScreeningTime(t);
//		String s2 = "00:30";
//		String d2 = "2020-02-12";
////		s.setScreeningTime(this.getTimeFromString(s2));
////		s.setScreeningDate(this.getDateFromString(d2));
////		Window.alert(this.getDateFromString(d2).toString());
//		dB = new DateBox();
//		this.add(dB);
//		b = new Button("Show");
//		b.addClickHandler(new SaveDateClickHandler());
//		this.add(b);
//
//		MultiWordSuggestOracle oracle = new MultiWordSuggestOracle();
//		   for(int i=0;i<24;i++) {
//			   String s = "";
//			   if(i<10) {
//			   s = "0"+Integer.toString(i);
//			   }else {
//			   s = Integer.toString(i);   
//			   }
//			   oracle.add(s);
//		   }
//
//		box = new SuggestBox(oracle);
//		box.getElement().setPropertyString("placeholder", "hh");
//		
////		textBox = new TextBox();
//
//		box.addKeyPressHandler(new KeyPressHandler() {
//		    @Override
//		    public void onKeyPress(KeyPressEvent event) {
//		        String input = box.getText();
////		        if (!input.matches("[0-9]*")) {
//		        if (input.length()==1) {
////		            Window.alert("Only Integers allowed. Fomat hh");
//		            dB.setFocus(true);
//		            return;
//		        }
//		        // do your thang
//		    }
//		});
//		this.add(box);
//		this.add(textBox);
		
		
		
//		SimpleDateFormat dt = new SimpleDateFormat("dd.mm.yyyy");
//		try {
//			Date d = dt.parse(s);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		
//		s = new Screening();
//		try {
//			Date date;
//			date = new SimpleDateFormat("dd/MM/yyyy").parse("31/12/2019");
//			s.setDate(date);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//			s.setCinemaFK(1);
//			s.setMovieFK(1);
//		
		
		
	}

//	class SaveDateClickHandler implements ClickHandler{
//
//		@Override
//		public void onClick(ClickEvent event) {
//
//		}
//		
//	}
//	
	
	public void showCinemas() {
		this.clear();
//		this.add(new Label("Cinemas"));
		cinemaAdministration.getCinemasByPersonFK(1, new GetCinemasByPersonCallback(this));
		
//		CinemaCard cinemaCard = new CinemaCard(this, c);
//		this.add(cinemaCard);
		
		//Get all cinemas where user is permitted to
		//for every cinema...
		//create a new CinemaCard
	}
	
	class GetCinemasByPersonCallback implements AsyncCallback<Vector<Cinema>>{
		Content content;
		public GetCinemasByPersonCallback(Content content) {
			// TODO Auto-generated constructor stub
			this.content = content;
		}
		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			Window.alert("Problem with the Callback!");
		}
		@Override
		public void onSuccess(Vector<Cinema> result) {
			// TODO Auto-generated method stub
			for(Cinema c: result) {
				CinemaCard cinemaCard = new CinemaCard(content,c);
				content.add(cinemaCard);
			}
			
		}

		
		
	}
	
	public void showMovies() {
		this.clear();
		cinemaAdministration.getAllMovies(new GetMoviesCallback(this));

	}
	class GetMoviesCallback implements AsyncCallback<Vector<Movie>>{
		Content content;
		public GetMoviesCallback(Content content) {
			// TODO Auto-generated constructor stub
			this.content = content;
		}

		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			Window.alert("Problem with the Callback!");
		}

		@Override
		public void onSuccess(Vector<Movie> result) {
			// TODO Auto-generated method stub
			for(Movie m: result) {
				MovieCard movieCard = new MovieCard(content, m);
				content.add(movieCard);
			}
		}
		
	}

	public void showScreenings() {
		this.clear();
		cinemaAdministration.getScreeningsByPersonFK(user.getId(), new GetScreeningsCallback(this));
	}
	
	class GetScreeningsCallback implements AsyncCallback<Vector<Screening>>{
		Content content;
		public GetScreeningsCallback(Content content) {
			// TODO Auto-generated constructor stub
			this.content=content;
		}

		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onSuccess(Vector<Screening> result) {
			// TODO Auto-generated method stub
			for(Screening s:result) {
				ScreeningCard screeningCard = new ScreeningCard(content,s);
				content.add(screeningCard);
			}
		}
		
	}
//	public Time getTimeFromString(String s2) {
//		Time t;
//			try {
//			SimpleDateFormat sDF = new SimpleDateFormat("hh:mm");
//			t = (Time) sDF.parse(s2);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return null;
//		}
//			return t;
//	}
//	public Date getDateFromString(String dateString) {
//		    Date result;
//		    try {
//		        DateTimeFormat dateTimeFormat = DateTimeFormat.getFormat("yyyy-MM-dd");
//		        result = (Date) dateTimeFormat.parse(dateString);
//		        Window.alert(dateString);
//		        return result;
//		    } catch (Exception e){
//		    	e.printStackTrace();
//		    	 Window.alert("Fail");
//		    	return null;
//		        // ignore
//		    }
//		 
//		}

	public void showCinemaChains() {
		// TODO Auto-generated method stub
		this.clear();
		cinemaAdministration.getCinemaChainByPersonFK(user.getId(), new CinemaChainCallback(this));
	}
	
	class CinemaChainCallback implements AsyncCallback<Vector<CinemaChain>>{
		Content content;
		public CinemaChainCallback(Content content) {
			this.content = content;
		}

		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onSuccess(Vector<CinemaChain> result) {
			for(CinemaChain cC: result) {
				CinemaChainCard cinemaChainCard = new CinemaChainCard(content,cC);
				content.add(cinemaChainCard);
			}
			
		}

		
		
		
	}
}
