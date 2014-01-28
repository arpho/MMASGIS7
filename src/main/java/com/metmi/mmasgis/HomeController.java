package com.metmi.mmasgis;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.ContextLoader;

import com.metmi.mmasgis.dao.DbImpl;
import com.metmi.mmasgis.model.Db;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Inject
	DbImpl dbs;
	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Ciao Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	/**
	 * get the database list in Mysql
	 */
	@RequestMapping(value = "/db", method = RequestMethod.GET)
	public String dbs(Locale locale, Model model) {
		ApplicationContext ctx = ContextLoader
				.getCurrentWebApplicationContext();
		DataSource ds = (DataSource) ctx.getBean("dataSource");
		dbs = new DbImpl();
		dbs.setDataSource(ds);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		ArrayList<Db> dbList = dbs.getDatabases();
		model.addAttribute("serverTime", formattedDate);
		model.addAttribute("dbList", dbList);
		logger.info("dbList! The client locale is {}.", locale);
		return "dbs";
	}

	/**
	 * Simply shows ciao.
	 */
	@RequestMapping(value = "/ciao", method = RequestMethod.GET)
	public String ciao(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "ciao";
	}

}
