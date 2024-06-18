package com.soap.lms;

import com.soap.lms.client.gen.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.Scanner;
import org.springframework.ws.soap.client.SoapFaultClientException;


@SpringBootApplication
public class ConsumingWebServiceApplication {

	public long userLoginId = 0;
	boolean exit = false;

	public static void main(String[] args) {
		SpringApplication.run(ConsumingWebServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner lookup(LMSClient lmsClient) {
		return args -> {
			while (!exit) {
				try {
					Scanner scanner = new Scanner(System.in);

					System.out.println("1-Login");
					System.out.println("2-Search Books By Name");
					System.out.println("3-Search Books By Author");
					System.out.println("4-Search Books By ID");
					System.out.println("5-Show User Informations");
					System.out.println("6-Add Borrow Book");
					System.out.println("7-Add Return Book");
					System.out.println("8-Add Book");
					System.out.println("9-Delete Book");
					System.out.println("10-Quit");

					System.out.println("\nPlease select an operation:\n");

					int choice = scanner.nextInt();
					scanner.nextLine();

					switch (choice) {
						case 1:
							System.out.println("Enter email:");
							String email = scanner.nextLine();
							System.out.println("Enter password:");
							String password = scanner.nextLine();
							LoginResponse loginResponse = lmsClient.login(email, password);
							userLoginId = loginResponse.getUserLoginInfos().getUserId();
							System.out.println("\nLogin Successfully:");
							System.out.println("User ID: " + userLoginId);
							System.out.println("User Type: " + loginResponse.getUserLoginInfos().getUserType() + "\n");
							break;
						case 2:
							System.out.println("Enter book name:");
							String bookName = scanner.nextLine();
							GetSearchedBooksResponse booksByNameResponse = lmsClient.getSearchedBooksByNameResponse(userLoginId, bookName);
							System.out.println("\nFounded books:");
							for (Book book : booksByNameResponse.getBook()) {
								System.out.println("Book ID: " + book.getId());
								System.out.println("Book Name: " + book.getName());
								System.out.println("Book Author: " + book.getAuthor());
								System.out.println("Book Type: " + book.getType());
								System.out.println("Book Location: " + book.getLocation());
								System.out.println("Book Availability: " + book.getAvailable() + "\n");

							}
							break;
						case 3:
							System.out.println("Enter author name:");
							String authorName = scanner.nextLine();
							GetSearchedBooksResponse booksByAuthorResponse = lmsClient.getSearchedBooksByAuthorResponse(userLoginId, authorName);
							System.out.println("\nFounded books:");
							for (Book book : booksByAuthorResponse.getBook()) {
								System.out.println("Book ID: " + book.getId());
								System.out.println("Book Name: " + book.getName());
								System.out.println("Book Author: " + book.getAuthor());
								System.out.println("Book Type: " + book.getType());
								System.out.println("Book Location: " + book.getLocation());
								System.out.println("Book Availability: " + book.getAvailable() + "\n");
							}
							break;
						case 4:
							System.out.println("Enter book ID:");
							long bookID = scanner.nextLong();
							GetSearchedBooksResponse bookByIDResponse = lmsClient.getSearchedBookByIDResponse(userLoginId, bookID);
							System.out.println("\nFounded books:");
							Book book = bookByIDResponse.getBook().get(0);
							System.out.println("Book ID: " + book.getId());
							System.out.println("Book Name: " + book.getName());
							System.out.println("Book Author: " + book.getAuthor());
							System.out.println("Book Type: " + book.getType());
							System.out.println("Book Location: " + book.getLocation());
							System.out.println("Book Availability: " + book.getAvailable() + "\n");
							break;
						case 5:
							System.out.println("Enter student ID:");
							long studentId = scanner.nextLong();
							GetUserBorrowingInfosResponse userBorrowingInfosResponse = lmsClient.getUserBorrowingInfosResponse(userLoginId, studentId);
							System.out.println("\nUser Informations:");
							for (UserBorrowingInfos info : userBorrowingInfosResponse.getBorrowingInfo()) {
								System.out.println("Book ID: " + info.getBook().getId());
								System.out.println("Book Name: " + info.getBook().getName());
								System.out.println("Book Author: " + info.getBook().getAuthor());
								System.out.println("Book Type: " + info.getBook().getType());
								System.out.println("Book's Current Location: " + info.getBook().getLocation());
								System.out.println("Book's Current Availability: " + info.getBook().getAvailable());
								System.out.println("Borrowing Time: " + info.getBorrowingTime());
								System.out.println("Due Date: " + info.getDueDate());
								System.out.println("Returning Time: " + info.getReturningTime());
								System.out.println("Paid: " + info.getPaid());
								System.out.println("Fine: " + info.getFine() + "\n");
							}
							break;
						case 6:
							System.out.println("Enter book ID:");
							long borrowBookID = scanner.nextLong();
							scanner.nextLine();
							System.out.println("Enter student ID:");
							long borrowBookStudentId = scanner.nextLong();
							scanner.nextLine();
							System.out.println("Enter borrowing time: (in yyyy-MM-dd:HH-mm-ss format)");
							String borrowingTime = scanner.nextLine();
							System.out.println("Enter due date: (in yyyy-MM-dd:HH-mm-ss format)");
							String dueDate = scanner.nextLine();
							BorrowBook borrowBook = new BorrowBook();
							borrowBook.setStudentId(borrowBookStudentId);
							borrowBook.setBookId(borrowBookID);
							borrowBook.setBorrowingTime(convertStringToXMLGregorianCalendar(borrowingTime));
							borrowBook.setDueDate(convertStringToXMLGregorianCalendar(dueDate));
							AddBorrowBookResponse addBorrowBookResponse = lmsClient.addBorrowBookResponse(userLoginId, borrowBook);
							System.out.println("\nBook borrowed successfully:");
							System.out.println("Response :" + addBorrowBookResponse.getReturnVal() + "\n");
							break;
						case 7:
							System.out.println("Enter book ID:");
							long returnBookID = scanner.nextLong();
							System.out.println("Enter student ID:");
							long returnBookStudentId = scanner.nextLong();
							scanner.nextLine();
							System.out.println("Enter return time: (in yyyy-MM-dd:HH-mm-ss format)");
							String returnTime = scanner.nextLine();
							ReturnBook returnBook = new ReturnBook();
							returnBook.setStudentId(returnBookStudentId);
							returnBook.setBookId(returnBookID);
							returnBook.setReturningTime(convertStringToXMLGregorianCalendar(returnTime));
							AddReturnBookResponse addReturnBookResponse = lmsClient.addReturnBookResponse(userLoginId, returnBook);
							System.out.println("\nBook returned successfully:");
							System.out.println("Response :" + addReturnBookResponse.getReturnVal() + "\n");
							break;
						case 8:
							System.out.println("Enter book name:");
							String bookNameToAdd = scanner.nextLine();
							System.out.println("Enter book type:");
							String bookType = scanner.nextLine();
							System.out.println("Enter author name:");
							String bookAuthor = scanner.nextLine();
							System.out.println("Enter book location:");
							String bookLocation = scanner.nextLine();
							AddBook addBook = new AddBook();
							addBook.setName(bookNameToAdd);
							addBook.setType(convertStringToType(bookType));
							addBook.setAuthor(bookAuthor);
							addBook.setLocation(bookLocation);
							AddBookResponse addBookResponse = lmsClient.addBookResponse(userLoginId, addBook);
							System.out.println("\nBook added successfully:");
							System.out.println("New Book ID: " + addBookResponse.getBookId() + "\n");
							break;
						case 9:
							System.out.println("Enter book ID to delete:");
							long bookIDToDelete = scanner.nextLong();
							DeleteBookResponse deleteBookResponse = lmsClient.deleteBookResponse(userLoginId, bookIDToDelete);
							System.out.println("\nBook deleted successfully:");
							System.out.println("Response :" + deleteBookResponse.getReturnVal() + "\n");
							break;
						case 10:
							exit = true;
							System.exit(0);
							break;
						default:
							System.out.println("\nInvalid choice." + "\n");
					}
				} catch (SoapFaultClientException ex) {
					String faultCode = ex.getFaultCode().toString();
					String faultString = ex.getFaultStringOrReason();

					System.out.println("\nSOAP Fault Code: " + faultCode);
					System.out.println("SOAP Fault String: " + faultString + "\n");
				} catch (NumberFormatException ex) {
					System.out.println("\nYou have to give an integer value not any others \n");
				} catch (InputMismatchException ex) {
					System.out.println("\nYou have to give an integer value not any others \n");
				}
			}
		};
	}

	public static XMLGregorianCalendar convertStringToXMLGregorianCalendar(String dateString) throws ParseException, DatatypeConfigurationException {
		try {
			Date date = new SimpleDateFormat("yyyy-MM-dd:HH-mm-ss").parse(dateString);
			return DatatypeFactory.newInstance().newXMLGregorianCalendar(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(date));
		} catch (ParseException | DatatypeConfigurationException e) {
			throw e;
		}
	}

	public static BookType convertStringToType(String type){
		if (type.equals("biology")){
			return BookType.BIOLOGY;
		} else if (type.equals("mathematic")) {
			return BookType.MATHEMATICS;
		}
		else {
			return BookType.MATHEMATICS;
		}
	}
}
