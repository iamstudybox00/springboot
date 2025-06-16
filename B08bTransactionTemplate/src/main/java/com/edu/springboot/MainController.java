package com.edu.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edu.springboot.jdbc.ITicketService;
import com.edu.springboot.jdbc.PayDTO;
import com.edu.springboot.jdbc.TicketDTO;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MainController
{
	@Autowired
	ITicketService dao;
	
	@Autowired
	TransactionTemplate transactionTemplate;
	
	@RequestMapping("/")
	public String home() 
	{
		return "home";
	}
	
	@GetMapping("/buyTicket.do")
	public String buy1()
	{
		return "buy";
	}
	
	@PostMapping("/buyTicket.do")
	public String buy2(TicketDTO ticketDTO, PayDTO payDTO,
			HttpServletRequest req, Model model)
	{
		String viewPath = "success";
		try
		{
			transactionTemplate.execute(new TransactionCallbackWithoutResult()
			{
				@Override
				protected void doInTransactionWithoutResult(TransactionStatus status)
				{
										
					payDTO.setAmount(ticketDTO.getT_count() * 10000);
					int result1 = dao.payInsert(payDTO);
					if(result1 == 1) System.out.println("transaction_pay 입력성공");
					
					// 비즈니스로직 처리(의도적인 에러발생)
					String errFlag = req.getParameter("err_flag");
					if(errFlag != null)
					{
						int money = Integer.parseInt("100원");
					}
					
					// DB처리2
					int result2 = dao.ticketInsert(ticketDTO);
					if(result2 == 1) System.out.println("transaction_ticket 입력성공");
					
					model.addAttribute("ticketDTO", ticketDTO);
					model.addAttribute("payDTO", payDTO);
				}
			});			
		} catch (Exception e)
		{
			e.printStackTrace();
			viewPath = "error";
		}
		return viewPath;
	}
}
