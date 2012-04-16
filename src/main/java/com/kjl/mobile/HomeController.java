package com.kjl.mobile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.joda.time.DateTime;
import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.site.SitePreference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController extends AbstractController {
	
	private List<NewsItem> news = new ArrayList<NewsItem>();
	
	private List<Alert> alerts = new ArrayList<Alert>();
	
	public HomeController() {	
		init();
	}
	
	private void init() {
		StringBuilder sb = new StringBuilder();
		sb.append("The illustrations system is well on its way after acquiring new actuarial resources. ");
		sb.append("Ben A is over the moon at the sound of such news and continues to work closely with the actuaries. ");
		sb.append("His new book \"An introduction to Actuarial Algorithms\" is due to be published soon.");
		news.add(new NewsItem(1, "2012 Illustrations system gets actuarial resource", sb.toString(), new Date()));
		
		DateTime dt = new DateTime();

		sb = new StringBuilder();
		sb.append("Changes to Universal Personal Portfolio charging options are to come into effect in next month ...");
		news.add(new NewsItem(2, "UPP Charges", sb.toString(), dt.minusDays(45).toDate()));
		
		sb = new StringBuilder();
		sb.append("In typical fashion, we're being screwed with a significant price-hike of around £30 (after taxes) between the US Kindle Touch and the UK model, which is now available to pre-order from tonight. But what the heck -- £109 is still a pretty decent price, especially considering the new model is touchscreen and comes with the handy X-ray tool for skimming 'n cribbing up on characters");
		sb.append("n our US brothers’ review of the Kindle Touch, they called it the “only book gadget you need,” and after a brief play around with one yesterday, I was suitably impressed with how lightweight it felt, and the responsiveness of the touchscreen.");
		sb.append("<p>Both Wi-Fi and 3G models are available to pre-order from tonight, with the Wi-Fi version costing £109 and the 3G a more hefty £169. Battery life has been improved to two months (based on around 30 minutes’ usage each day), and the storage has been upped to the point where each Kindle can hold 3,000 books comfortably.</p>");
		news.add(new NewsItem(3, "Amazon’s Kindle Touch Now Available For Pre-Order In UK (With Hefty UK Price Hike)", sb.toString(), dt.minusYears(1).toDate()));
		
		sb = new StringBuilder();
		sb.append("The Hansard JP Morgan Global Consumer Trends fund has been added to both the Hansard International (HIL) and Hansard Europe (HEL) unit-linked fund ranges in March, in response to market and IFA demand.");
        sb.append("MC142 (HIL) is $ denominated, and links to the underlying JP Morgan fund of the same currency, whilst MX54 (HEL) is € denominated, and links to the underlying JP Morgan fund of the same currency.");
        sb.append("The fund aims to profit from long-term changes in the consumer landscape, it targets lucrative opportunities in consumption driven by aspiration, demographics & urbanisation and health & wellness. The fund is not constrained by a benchmark, all avenues can be explored, regardless of size, sector or location.");
		news.add(new NewsItem(4, "New unit funds added to the Hansard range", sb.toString(), dt.minusMonths(3).toDate()));
		
		//alerts
		sb = new StringBuilder();
		sb.append("Your password has now been reset successfully ...");
		alerts.add(new Alert(1, "Your have reset your password successfully", sb.toString()));
		
		sb = new StringBuilder();
		sb.append("Welcome to your new Client Site. You can access the latest information about your policies and linked assets via the internet.");
        sb.append("Depending on your product, you can see fund information, valuations, correspondence and much more in English, Dutch, French, German, Italian, Japanese, Mandarin, Norwegian, Portuguese, Spanish, or Swedish.");
		alerts.add(new Alert(2, "Your Client Site is now activated!", sb.toString()));
		
		sb = new StringBuilder();
		sb.append("Want to sign-up for a Client Site?");
		alerts.add(new Alert(3, "Click here to sign-up for a Client Site", sb.toString()));
	}
	
	@RequestMapping(value="/")
	public String handleRoot() {
		return "forward:/browse/home";
	}
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String home(HttpServletRequest request, Model model, SitePreference sitePreference) {
		LOGGER.info("Home");
		if (request.getSession(false) == null) {
			request.getSession(true);
		} else {
			if (getSwatch(request) == null) {
				defaultSwatch(request);
			}
		}
		
		addSwatchToModel(request, model);
		
		String view = (sitePreference == SitePreference.MOBILE) ? "home_mobile" : "home_normal";
		//addLastView(request, view);
		
		return view;
	}
	
	@RequestMapping(value="/policies", method=RequestMethod.GET)
	public String policies(HttpServletRequest request, Model model, SitePreference sitePreference) {
		LOGGER.info("Policies");
		addSwatchToModel(request, model);
		String view = (sitePreference == SitePreference.MOBILE) ? "policies_mobile" : "policies_normal";
		//addLastView(request, view);
		return view;
	}
	
	@RequestMapping(value="/funds", method=RequestMethod.GET)
	public String funds(HttpServletRequest request, Model model, SitePreference sitePreference) {
		LOGGER.info("Funds");
		addSwatchToModel(request, model);
		String view = (sitePreference == SitePreference.MOBILE) ? "funds_mobile" : "funds_normal";
		//addLastView(request, view);
		return view;
	}
	
	@RequestMapping(value="/profile", method=RequestMethod.GET)
	public String profile(HttpServletRequest request, Model model, SitePreference sitePreference, Device device) {
		LOGGER.info("Profile");
		addSwatchToModel(request, model);
		String view = (sitePreference == SitePreference.MOBILE) ? "profile_mobile" : "profile_normal";
		//addLastView(request, view);
		return view;
	}
	
	@RequestMapping(value="/profile", method=RequestMethod.POST)
	public String profileSubmit(HttpServletRequest request, Model model, SitePreference sitePreference, 
						 @RequestParam(value="emailAddress") String emailAddress, @RequestParam(value="telNo") String telNo) {
		LOGGER.info(String.format("Profile Submit %s %s", emailAddress, telNo));
		addSwatchToModel(request, model);
		String view = (sitePreference == SitePreference.MOBILE) ? "profile_mobile" : "profile_normal";
		//addLastView(request, view);
		return view;
	}
	
	@RequestMapping(value="/news", method=RequestMethod.GET)
	public String news(HttpServletRequest request, Model model, SitePreference sitePreference) {
		LOGGER.info("News");
		addSwatchToModel(request, model);
		String view = (sitePreference == SitePreference.MOBILE) ? "news_mobile"  : "news_normal";
		//addLastView(request, view);
		model.addAttribute("news", news);
		return view;
	}
	
	@RequestMapping(value="/news-item", method=RequestMethod.GET)
	public String newsItem(HttpServletRequest request, Model model, SitePreference sitePreference, 
						   @RequestParam(value="itemNo")Integer newsNo) {
		LOGGER.info("News Item");
		addSwatchToModel(request, model);
		String view = (sitePreference == SitePreference.MOBILE) ? "news_item_mobile"  : "news_item_normal";
		//addLastView(request, view);
		NewsItem newsItem = null;
		for (NewsItem item : news) {
			if (item.getNewsNo() == newsNo) {
				newsItem = item;
			}
		}
		model.addAttribute("newsItem", newsItem);
		return view;
	}
	
	@RequestMapping(value="/alerts", method=RequestMethod.GET)
	public String alerts(HttpServletRequest request, Model model, SitePreference sitePreference) {
		LOGGER.info("Alerts");
		addSwatchToModel(request, model);
		String view = (sitePreference == SitePreference.MOBILE) ? "alerts_mobile"  : "alerts_normal";
		//addLastView(request, view);
		model.addAttribute("alerts", alerts);
		return view;
	}
	
	@RequestMapping(value="/alerts-item", method=RequestMethod.GET)
	public String alertsItem(HttpServletRequest request, Model model, SitePreference sitePreference, 
						   @RequestParam(value="alertId")Integer alertId) {
		LOGGER.info("Alerts Item");
		addSwatchToModel(request, model);
		String view = (sitePreference == SitePreference.MOBILE) ? "alerts_item_mobile"  : "alerts_item_normal";
		//addLastView(request, view);
		Alert alert = null;
		for (Alert item : alerts) {
			if (item.getAlertId() == alertId) {
				alert = item;
			}
		}
		model.addAttribute("alert", alert);
		return view;
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		
		return "forward:/browse/home";
	}

	public class NewsItem {
		
		private int newsNo;
		private String title = null;
		private String news = null;
		private Date date;
		
		public NewsItem(int no, String title, String news, Date date) {
			this.newsNo = no;
			this.title = title;
			this.news = news;
			this.date = date;
		}

		public int getNewsNo() {
			return newsNo;
		}

		public void setNewsNo(int newsNo) {
			this.newsNo = newsNo;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getNews() {
			return news;
		}

		public void setNews(String news) {
			this.news = news;
		}

		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}	}
	
	public class Alert {
		private int alertId;
		private String alertTitle;
		private String alertMessage;
		
		public Alert(int alertId, String alertTitle, String alertMessage) {
			this.alertId = alertId;
			this.alertTitle = alertTitle;
			this.alertMessage = alertMessage;
		}

		public int getAlertId() {
			return alertId;
		}

		public void setAlertId(int alertId) {
			this.alertId = alertId;
		}

		public String getAlertTitle() {
			return alertTitle;
		}

		public void setAlertTitle(String alertTitle) {
			this.alertTitle = alertTitle;
		}

		public String getAlertMessage() {
			return alertMessage;
		}

		public void setAlertMessage(String alertMessage) {
			this.alertMessage = alertMessage;
		}
	}
}

