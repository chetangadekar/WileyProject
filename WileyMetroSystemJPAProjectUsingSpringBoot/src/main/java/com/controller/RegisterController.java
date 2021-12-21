package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.bean.CardDetails;
import com.bean.Station;
import com.model.exception.CardNumberNotFoundException;
import com.model.service.RegisterService;
import com.model.service.StationService;
import com.model.service.SwipeInService;
import com.model.service.SwipeOutService;

@Controller
@SessionAttributes({"card"})
public class RegisterController {
	@Autowired
	RegisterService registerService;
	@Autowired
	SwipeInService swipeInService;
	@Autowired
	SwipeOutService swipeOutService;
	@Autowired
	StationService stationService;
	
	
	@RequestMapping("/")
	public ModelAndView Home() {
		return new ModelAndView("Home");
	}
	//if new user than generation of id card
	@RequestMapping("/newUser")
	public ModelAndView newUserController() {
		return new ModelAndView("newUser");
	}
	
	@RequestMapping("/generateId")
	public ModelAndView cardNumberGeneration() {
		int message=0;
			try {
				message=registerService.registerPassenger();
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		return new ModelAndView("registerDisplay","message",message);
	}
	@RequestMapping("/loginPage")
	public ModelAndView oldUser() {
		return new ModelAndView("login","command",new CardDetails());
	}

	@RequestMapping(value ="/loginCheck", method = RequestMethod.POST)
	public ModelAndView showMenuController(@ModelAttribute("command") CardDetails card) {	
		try {
				if(registerService.isValidCardOfPassenger(card.getCardNumber())){
					ModelAndView mv=new ModelAndView();
					mv.addObject("card", card);
					if(swipeInService.swipeInCheckStatusOfPassenger(card.getCardNumber())) {
					mv.setViewName("swipeOut");
					return mv;
				}else {
					mv.setViewName("swipeIn");
					return mv;
				}
				}
			} catch (Exception e) {
			}
			return new ModelAndView("login", "message","Login Failed");
	}
	
	
	@RequestMapping("/swipeInPage")
	public ModelAndView swipeInCustomer(@ModelAttribute("command")Station stations,Model model) throws Exception {
		List<Station> st=stationService.StationList();
		return new ModelAndView("swipeInStation","stations",st);
	}
	
	@RequestMapping("/swipeIn")
		public ModelAndView swipeIn(@ModelAttribute("command") Station station,Model model) throws Exception {
		CardDetails card=(CardDetails)model.getAttribute("card");
		String message=null;
		if(swipeInService.swipeInPassenger(card.getCardNumber(), station)) {
			message="Swipe In Succesfully at station "+stationService.passengerStationName(station.getStationId());
		}else {
			message="Swiped In Failed";
		}
		return new ModelAndView("afterOutput","message",message);
		}
	
	
	
	@RequestMapping("/swipeOutPage")
	public ModelAndView swipeOutCustomer(@ModelAttribute("command")Station stations,Model model) throws Exception {
		List<Station> st=stationService.StationList();
		return new ModelAndView("swipeOutStation","stations",st);
	}
	
	@RequestMapping("/swipeOut")
	public ModelAndView swipeOut(@ModelAttribute("command")Station station,Model model) throws Exception {
		CardDetails card=(CardDetails)model.getAttribute("card");
		String message=null;
		int balance=registerService.checkBalance(card.getCardNumber());
		if(balance>25) {
		if(swipeOutService.swipeOutPassenger(card.getCardNumber(),station)) {
		message="Swiped out Succesfully your fare is : Rs."+swipeOutService.getFare(card.getCardNumber());
		return new ModelAndView("afterOutput","message",message);
		}else {
			message="Couldnt Swipe Out Please Try Later....";
			return new ModelAndView("afterOutput","message",message);
		}
		}else {
			message="Your Balance is Low Please Recharge to travel with us.";
			return new ModelAndView("afterOutput","message",message);
		}
		
	}
	
	
	@RequestMapping("/updateBalancePage")
	public ModelAndView updateBalanceCustomer(Model model) {		
		return new ModelAndView("updateBalance");
	}
	
	@RequestMapping("/updateBalance")
	public ModelAndView updateBalance(@RequestParam("balance") int balance,Model model) throws CardNumberNotFoundException 
	{	
		CardDetails card=(CardDetails)model.getAttribute("card");
		if(balance<0) {
			return new ModelAndView("updateBalance","message","Balance cannot be Negative");	
		}else if(registerService.updateBalance(card.getCardNumber(), balance)) {
			return new ModelAndView("afterOutput","message","Balance Updated Succesfully");
		}else {
				return new ModelAndView("afterOutput","message","Balance Updation Failed");	
		}
	}
	
	
	
	@RequestMapping("/checkBalancePage")
	public ModelAndView checkBalance(Model model) throws CardNumberNotFoundException{
		CardDetails card=(CardDetails)model.getAttribute("card");
		int balance=registerService.checkBalance(card.getCardNumber());
		return new ModelAndView("balanceOutput","message",balance);
	}
	
	@RequestMapping("/goBack")
	public ModelAndView goBack(Model model) {
		CardDetails card=(CardDetails)model.getAttribute("card");
		try {
			if(registerService.isValidCardOfPassenger(card.getCardNumber())){
				ModelAndView mv=new ModelAndView();
				mv.addObject("card", card);
				if(swipeInService.swipeInCheckStatusOfPassenger(card.getCardNumber())) {
				mv.setViewName("swipeOut");
				return mv;
			}else {
				mv.setViewName("swipeIn");
				return mv;
			}
			}
		} catch (Exception e) {
		}
		return new ModelAndView("login", "message","Login Failed");
}

	@RequestMapping("/logOut")
	public ModelAndView logOut(HttpSession session) {
		session.invalidate();
	    String message = "Thank you for using Metro System!";
	    return new ModelAndView("output","message",message);
		}
	}



		
	
	
	




