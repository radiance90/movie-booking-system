package control;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Pattern;

import javax.security.auth.login.AccountException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.awt.windows.ThemeReader;



import model.*;

/**
 * Servlet implementation class control
 */
@WebServlet("/control")
public class control extends HttpServlet {
	private static final long serialVersionUID = 1L;

	MovieList movielist = new MovieList();
	ShowList showlist = new ShowList();
	OrderList orderlist = new OrderList();
	Movie movie;
	MovieCopy movie2;
	User user;
	Boolean user_login = false;
	Boolean manager_login = false;
	MovieManager moviemanager = new MovieManager();
	UserManager usermanager = new UserManager();
	CommentManager commentmanager = new CommentManager();
	ShowManage showmanager = new ShowManage();
	CinemaManage cinemamanager = new CinemaManage();
	OrderManager orderManager = new OrderManager();
	MailManager mailManager = new MailManager();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public control() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");

		if (action == null) {
			movielist = moviemanager.findAll(); // return all movie in
			MovieList nowShowlist = new MovieList();
			nowShowlist = Tool.getNowShowing(movielist);
			ArrayList<MovieCopy> comIngSoon = new ArrayList<MovieCopy>();
			comIngSoon = Tool.getComingSoon(movielist);
			request.getSession().setAttribute("showing", nowShowlist);
			request.getSession().setAttribute("coming", comIngSoon);
			RequestDispatcher view = request
					.getRequestDispatcher("welcome.jsp");
			view.forward(request, response);
		}
		else if (action.equals("fromlink")) {
			String uname = request.getParameter("user_name");
			
			user = usermanager.returnRole(uname);
			request.getSession().setAttribute("user", user);
			user_login = true;
			manager_login = false;
			RequestDispatcher view = request.getRequestDispatcher("profile.jsp");
			view.forward(request, response);
			
		}
		// not logged in, go login
		else if (!user_login && !manager_login) {
			response.sendRedirect("login.jsp");
		} else if (user_login) {
			// user action
			if (action.equals("userprofile")) {
				request.getSession().setAttribute("user", user);
				RequestDispatcher view = request
						.getRequestDispatcher("profile.jsp");
				view.forward(request, response);
			} else if (action.equals("usersearch")) {
				String keywords = request.getParameter("keywords");
				movielist = moviemanager.findSpecial(keywords);
				request.getSession().setAttribute("searchlist", movielist);
				request.getSession().setAttribute("listsize", movielist.size());
				RequestDispatcher view = request
						.getRequestDispatcher("user_result.jsp");
				view.forward(request, response);
			} else if (action.equals("detail")) {
				int pos = Integer.parseInt(request.getParameter("pos"));
				movie = movielist.get(pos);
				request.getSession().setAttribute("movie", movie);
				Boolean released = new java.util.Date().after(movie
						.getRelaseDate());
				request.getSession().setAttribute("released", released);
				CommentList commentlist = commentmanager
						.findSpecialMovie(movie);
				request.getSession().setAttribute("commentlist", commentlist);
				// System.out.println(commentlist.get(0).getReviews());
				request.getSession().setAttribute("commentsize",
						commentlist.size());
				ArrayList<String> cinemas = showmanager.findcinema(movie);
				cinemas = Tool.removeDupLocation(cinemas);
				request.getSession().setAttribute("cinemas", cinemas);
				request.getSession()
						.setAttribute("cinemassize", cinemas.size());
				RequestDispatcher view = request
						.getRequestDispatcher("detail.jsp");
				view.forward(request, response);
			}

			else if (action.equals("findtime")) {
				String cinema = request.getParameter("cinema");
				String date = request.getParameter("date");
				request.getSession().setAttribute("empty_date", false);
				request.getSession().setAttribute("invalid_date", false);
				if (date.equals("")) {
					request.getSession().setAttribute("empty_date", true);
				} else {
					String date_format = "yyyy-MM-dd";
					try {
						SimpleDateFormat df = new SimpleDateFormat(date_format);
						df.setLenient(false);
						df.parse(date);
						showlist = showmanager.showAllTime(date, cinema,
								movie.getTitle());
						request.getSession().setAttribute("showlist", showlist);
						// request.getSession().setAttribute("foundlist",true);
						request.getSession().setAttribute("timesize",
								showlist.size());

						// return true;
					} catch (Exception e) {
						request.getSession().setAttribute("invalid_date", true);
					}
				}
				RequestDispatcher view = request
						.getRequestDispatcher("booking.jsp");
				view.forward(request, response);
			} else if (action.equals("userbookings")) {
				orderlist = orderManager.returnOrder(user);
				System.out.println(orderlist.size());
				request.getSession().setAttribute("orderlist", orderlist);
				request.getSession().setAttribute("ordersize", orderlist.size());
				RequestDispatcher view = request
						.getRequestDispatcher("user_record.jsp");
				view.forward(request, response);
			}  

		} else if (manager_login) {
			// manager action
			if (action.equals("manager_search")) {
				
				String keywords = request.getParameter("keywords");
				movielist = moviemanager.findSpecialOwner(keywords);
				request.getSession().setAttribute("searchlist", movielist);
				request.getSession().setAttribute("listsize", movielist.size());
				RequestDispatcher view = request
						.getRequestDispatcher("manager_result.jsp");
				view.forward(request, response);
			}
			else if (action.equals("addone")) {
				//System.out.println("here");
				int pos = Integer.parseInt(request.getParameter("pos"));
				movie = movielist.get(pos);
				request.getSession().setAttribute("movie", movie);
				CinemaList cinemalist = cinemamanager.findall();
				request.getSession().setAttribute("cinemalist", cinemalist);
				RequestDispatcher view = request
						.getRequestDispatcher("addtime.jsp");
				view.forward(request, response);
			}
			
		} 

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");
		// user_login = (Boolean)
		// request.getSession().getAttribute("user_login");
		if (action.equals("register")) {

			String user_name = request.getParameter("user_name");
			String password = request.getParameter("password");
			String email = request.getParameter("email");
			request.getSession().setAttribute("registered", true);
			request.getSession().setAttribute("wrong_name", false);
			request.getSession().setAttribute("duplicate_name", false);
			request.getSession().setAttribute("empty_pass", false);
			request.getSession().setAttribute("empty_email", false);

			if (password.equals("")) {
				request.getSession().setAttribute("empty_pass", true);
				request.getSession().setAttribute("registered", false);

			}
			if (email.equals("")
					|| !Pattern.matches("^.+@\\w+.[\\.\\w]+$", email)) {
				request.getSession().setAttribute("empty_email", true);
				request.getSession().setAttribute("registered", false);

			}
			if (user_name.equals("") || !Pattern.matches("^[\\w]+$", user_name)) {
				request.getSession().setAttribute("wrong_name", true);
				request.getSession().setAttribute("registered", false);

			} else {
				// pass parameter
				User newuser = new User(user_name, password, email);
				// user.setStatus("no");

				Boolean duplicate_name = usermanager.addUser(newuser);
				if (!duplicate_name) {
					request.getSession().setAttribute("duplicate_name", true);
					request.getSession().setAttribute("registered", false);
				}
				else {
					String send = "http://localhost:8080/Assign2/control?action=fromlink&user_name=" + newuser.getACCOUNTNAME();
					String addr = newuser.getEMAIL();
					mailManager.SendMail(addr, send);
					// #TODO send email
					//http://localhost:8080/Assign2/control?action=fromlink&user_name=user_name	
				}
			}
			response.sendRedirect("registercomplete.jsp");

		} else if (action.equals("login")) {
			// login
			user_login = false;
			manager_login = false;

			String user_name = request.getParameter("user_name");
			String password = request.getParameter("password");
			request.getSession().setAttribute("manager_login", false);
			request.getSession().setAttribute("user_login", false);
			request.getSession().setAttribute("wrong_name", false);
			request.getSession().setAttribute("notexist_name", false);
			request.getSession().setAttribute("notconfirm", false);
			request.getSession().setAttribute("wrong_pass", false);
			request.getSession().setAttribute("empty_pass", false);
			if (password.equals("")) {
				request.getSession().setAttribute("empty_pass", true);
			}
			if (user_name.equals("") || !Pattern.matches("^[\\w]+$", user_name)) {
				request.getSession().setAttribute("wrong_name", true);
			} else {

				int check = usermanager.loginUser(user_name, password);
				if (check == -1) {
					request.getSession().setAttribute("notexist_name", true);
				} else if (check == 0) {
					request.getSession().setAttribute("wrong_pass", true);
				} else {
					user = usermanager.returnRole(user_name);
					String status = user.getStatus(); // yes no
					String role = user.getROLE(); // 1 customer 2 manager
					if (status.equals("no")) {
						request.getSession().setAttribute("notconfirm", true);
					} else if (role.equals("1")) {
						request.getSession().setAttribute("user_login", true);
						user_login = true;
					} else if (role.equals("2")) {
						request.getSession()
								.setAttribute("manager_login", true);
						manager_login = true;
					}
				}
			}
			response.sendRedirect("logincomplete.jsp");
		}
		// not logged in, go login
		else if (!user_login && !manager_login) {

			response.sendRedirect("login.jsp");
		} else if (user_login) {
			// user action
			if (action.equals("updateprofile")) {
				request.getSession().setAttribute("updated", false);
				request.getSession().setAttribute("wrong_email", false);
				request.getSession().setAttribute("empty_nick", false);
				String nickname = request.getParameter("nickname");
				String firstname = request.getParameter("firstname");
				String lastname = request.getParameter("lastname");
				String email = request.getParameter("email");
				// String year_of_birth = request.getParameter("year_of_birth");
				// String favourite_genre =
				// request.getParameter("favourite_genre");
				// String favourite_cast =
				// request.getParameter("favourite_cast");

				if (nickname == "") {
					request.getSession().setAttribute("empty_nick", true);
				} else if (!Pattern.matches("^.+@\\w+.[\\.\\w]+$", email)) {
					request.getSession().setAttribute("wrong_email", true);
				} else {

					user.setNICKNAME(nickname);
					user.setFIRSTNAME(firstname);
					user.setLASTNAME(lastname);
					user.setEMAIL(email);
					user.setStatus("yes");
					// user.set(year_of_birth);
					// user.set(favourite_genre);
					// user.set(favourite_cast);

					usermanager.updateUser(user);
					request.getSession().setAttribute("user", user);
					request.getSession().setAttribute("updated", true);
				}
				response.sendRedirect("profilecomplete.jsp");
			}

			else if (action.equals("addcomment")) {
				String title = movie.getTitle();
				String nickname = user.getNICKNAME();
				String comment = request.getParameter("newcomment");
				String rating = request.getParameter("newrating");
				System.out.println(title + nickname + comment + rating);
				commentmanager.addComment(title, nickname, comment, rating);
				movie = moviemanager.RateMovie(movie, rating);
				CommentList commentlist = commentmanager
						.findSpecialMovie(movie);
				request.getSession().setAttribute("commentlist", commentlist);
				request.getSession().setAttribute("commentsize",
						commentlist.size());
				response.sendRedirect("detail.jsp");
			} else if (action.equals("booking")) {
				request.getSession().setAttribute("notint", false);
				request.getSession().setAttribute("bookavail", false);
				request.getSession().setAttribute("negative", false);

				int time = Integer.parseInt(request.getParameter("time"));
				if (request.getParameter("ticket").equals("")) {
					request.getSession().setAttribute("notint", true);
				} else {
					try {
						int ticket = Integer.parseInt(request
								.getParameter("ticket"));
						if (ticket <= 0) {
							request.getSession().setAttribute("negative", true);
						} else {
							Show bookshow = showlist.get(time);

							if (Integer.parseInt(bookshow.getSeatLeft()) < ticket) {
								request.getSession().setAttribute("bookavail",
										false);
							} else {
								// showmanager.book(bookshow, ticket);
								request.getSession().setAttribute("bookavail",
										true);
								request.getSession().setAttribute("bookshow",
										bookshow);
								request.getSession().setAttribute("ticket",
										ticket);
							}
						}
					} catch (Exception e) {
						request.getSession().setAttribute("notint", true);
					}
				}

				response.sendRedirect("bookingcomplete.jsp");
			} else if (action.equals("checkout")) {
				// TODO
				// send email
				request.getSession().setAttribute("invalidcard", false);
				String card_name = request.getParameter("card_name");
				String card_num = request.getParameter("card_num");
				if (card_name == "" || card_num == ""
						|| !Pattern.matches("^[0-9]+$", card_num)) {
					request.getSession().setAttribute("invalidcard", true);
				} else {
					Show bookshow = (Show) request.getSession().getAttribute(
							"bookshow");
					int ticket = (Integer) request.getSession().getAttribute(
							"ticket");
					showmanager.book(bookshow, ticket, user.getACCOUNTNAME());
					String addr = user.getEMAIL();
					orderlist = orderManager.returnOrder(user);
					int lastorder = orderlist.size() - 1;
					Order order = orderlist.get(lastorder);
					String send = "Your order number is:" + order.getID() + '\n';
					mailManager.SendMail(addr, send);
				}
				response.sendRedirect("checkoutcomplete.jsp");
			}

		} else if (manager_login) {
			// manager action
			if (action.equals("addcinema")) {
				request.getSession().setAttribute("empty_loc", false);
				request.getSession().setAttribute("wrong_seat", false);
				request.getSession().setAttribute("addedcinema", false);
				String location = request.getParameter("location");
				String seatcap = request.getParameter("seatcap");
				String[] selectedam = request.getParameterValues("selectedam");
				String amenities = "";
				if (location.equals("")) {
					request.getSession().setAttribute("empty_loc", true);
				} else if (seatcap.equals("")
						|| !Pattern.matches("^[0-9]+$", seatcap)) {
					request.getSession().setAttribute("wrong_seat", true);
				} else {
					if (selectedam == null) {
					}

					else {

						for (String val : selectedam) {
							int index = Integer.parseInt(val);
							if (index == 0)
								amenities = amenities + " ATMs";
							if (index == 1)
								amenities = amenities + " widescreen";
							if (index == 2)
								amenities = amenities + " snackbar";
							if (index == 3)
								amenities = amenities + " restaurent";
						}
					}

					Cinema cinema = new Cinema(location, seatcap, amenities);
					Boolean addedcinema = cinemamanager.addCinema(cinema);
					if (addedcinema) {
						request.getSession().setAttribute("addedcinema", true);
					}
				}
				response.sendRedirect("addedcinema.jsp");
			} else if (action.equals("addmovie")) {
				String title = request.getParameter("title");
				String poster = request.getParameter("poster");
				String cast = request.getParameter("cast");
				String director = request.getParameter("director");
				String synopsis = request.getParameter("synopsis");
				String release = request.getParameter("release");
				String age = request.getParameter("age");
				String[] selectedgenre = request
						.getParameterValues("selectedgenre");
				String genres = "";
				request.getSession().setAttribute("invalid_release", false);
				request.getSession().setAttribute("empty_input", false);
				request.getSession().setAttribute("wrong_age", false);
				request.getSession().setAttribute("movieadded", false);
				if (title.equals("") || poster.equals("") || cast.equals("")
						|| director.equals("") || synopsis.equals("")
						|| release.equals("") || age.equals("")) {
					request.getSession().setAttribute("empty_input", true);
				} else if (age.equals("") || !Pattern.matches("^[0-9]+$", age)
						|| Pattern.matches("^[3][0-9]$", age)) {
					request.getSession().setAttribute("wrong_age", true);
				} else {
					String date_format = "yyyy-MM-dd";
					try {
						SimpleDateFormat df = new SimpleDateFormat(date_format);
						df.setLenient(false);
						df.parse(release);
						Date releasedate = new SimpleDateFormat("yyyy-MM-dd")
								.parse(release);
						if (new java.util.Date().after(releasedate)) {
							request.getSession().setAttribute(
									"invalid_release", true);
						} else {
							if (selectedgenre == null) {
								genres = " ";
							}

							else {

								for (String val : selectedgenre) {
									int index = Integer.parseInt(val);
									if (index == 0)
										genres = genres + " Romance";
									if (index == 1)
										genres = genres + " Horror";
									if (index == 2)
										genres = genres + " Thriller";
									if (index == 3)
										genres = genres + " Comedy";
									if (index == 4)
										genres = genres + " Drama";
									if (index == 5)
										genres = genres + " Biopic";
									if (index == 3)
										genres = genres + " Action";
								}
							}
							Movie amovie = new Movie(title, poster, cast,
									genres, director, synopsis, "0", age, "0",
									releasedate);
							Boolean movieadded = moviemanager.addMovie(amovie);
							if (movieadded) {
								request.getSession().setAttribute("movieadded",
										true);
							}
						}
					} catch (Exception e) {
						request.getSession().setAttribute("invalid_release",
								true);
					}
				}
				response.sendRedirect("addedmovie.jsp");
			}
			else if (action.equals("addtime")) {
				String selecteddate = request.getParameter("selecteddate");
				String selectedtime = request.getParameter("selectedtime");
				String selectedcinema = request.getParameter("selectedcinema");
				request.getSession().setAttribute("empty_in", false);
				request.getSession().setAttribute("invalid_newdate", false);
				request.getSession().setAttribute("timeadded",false);
				if (selectedtime == null || selectedcinema == null || selecteddate == null) {
					request.getSession().setAttribute("empty_in", true);
				}
				
				String date_format = "yyyy-MM-dd";
				try {
					SimpleDateFormat df = new SimpleDateFormat(date_format);
					df.setLenient(false);
					df.parse(selecteddate);
					Date newdate = new SimpleDateFormat("yyyy-MM-dd")
							.parse(selecteddate);
					if (new java.util.Date().after(newdate)) {
						request.getSession().setAttribute(
								"invalid_newdate", true);
					} else {
						
					}
					Boolean timeadded = showmanager.addShowing(selectedcinema, newdate, selectedtime, movie.getTitle());
					
					if (timeadded) {
						request.getSession().setAttribute("timeadded",true);
					}
					
				} catch (Exception e) {
				request.getSession().setAttribute("invalid_newdate",
						true);
				}
				response.sendRedirect("addedtime.jsp");
			}
		}
	}
}
