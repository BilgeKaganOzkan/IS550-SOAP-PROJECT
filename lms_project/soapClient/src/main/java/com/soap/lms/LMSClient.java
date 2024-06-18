package com.soap.lms;

import com.soap.lms.client.gen.*;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class LMSClient extends WebServiceGatewaySupport {

    public LoginResponse login(String email, String password) {
        LoginRequest request = new LoginRequest();
        request.setEmail(email);
        request.setPassword(password);

        LoginResponse response = (LoginResponse) getWebServiceTemplate().marshalSendAndReceive(request);

        return response;
    }

    public GetSearchedBooksResponse getSearchedBooksByNameResponse(long loginId, String name) {
        GetSearchedBooksRequest request = new GetSearchedBooksRequest();
        request.setLoginId(loginId);
        request.setName(name);

        GetSearchedBooksResponse response = (GetSearchedBooksResponse) getWebServiceTemplate().marshalSendAndReceive(request);

        return response;
    }

    public GetSearchedBooksResponse getSearchedBooksByAuthorResponse(long loginId, String author) {
        GetSearchedBooksRequest request = new GetSearchedBooksRequest();
        request.setLoginId(loginId);
        request.setAuthor(author);

        GetSearchedBooksResponse response = (GetSearchedBooksResponse) getWebServiceTemplate().marshalSendAndReceive(request);

        return response;
    }

    public GetSearchedBooksResponse getSearchedBookByIDResponse(long loginId, long bookId) {
        GetSearchedBooksRequest request = new GetSearchedBooksRequest();
        request.setLoginId(loginId);
        request.setBookId(bookId);

        GetSearchedBooksResponse response = (GetSearchedBooksResponse) getWebServiceTemplate().marshalSendAndReceive(request);

        return response;
    }

    public GetUserBorrowingInfosResponse getUserBorrowingInfosResponse(long loginId, long studentId) {
        GetUserBorrowingInfosRequest request = new GetUserBorrowingInfosRequest();
        request.setLoginId(loginId);
        request.setStudentId(studentId);

        GetUserBorrowingInfosResponse response = (GetUserBorrowingInfosResponse) getWebServiceTemplate().marshalSendAndReceive(request);

        return response;
    }
    public AddBorrowBookResponse addBorrowBookResponse(long loginId, BorrowBook book) {
        AddBorrowBookRequest request = new AddBorrowBookRequest();
        request.setLoginId(loginId);
        request.setBorrowBook(book);

        AddBorrowBookResponse response = (AddBorrowBookResponse) getWebServiceTemplate().marshalSendAndReceive(request);

        return response;
    }

    public AddReturnBookResponse addReturnBookResponse(long loginId, ReturnBook book) {
        AddReturnBookRequest request = new AddReturnBookRequest();
        request.setLoginId(loginId);
        request.setReturnBook(book);

        AddReturnBookResponse response = (AddReturnBookResponse) getWebServiceTemplate().marshalSendAndReceive(request);

        return response;
    }

    public AddBookResponse addBookResponse(long loginId, AddBook book) {
        AddBookRequest request = new AddBookRequest();
        request.setLoginId(loginId);
        request.setAddBook(book);

        AddBookResponse response = (AddBookResponse) getWebServiceTemplate().marshalSendAndReceive(request);

        return response;
    }

    public DeleteBookResponse deleteBookResponse(long loginId, long bookID) {
        DeleteBookRequest request = new DeleteBookRequest();
        request.setLoginId(loginId);
        request.setBookId(bookID);

        DeleteBookResponse response = (DeleteBookResponse) getWebServiceTemplate().marshalSendAndReceive(request);

        return response;
    }

}
