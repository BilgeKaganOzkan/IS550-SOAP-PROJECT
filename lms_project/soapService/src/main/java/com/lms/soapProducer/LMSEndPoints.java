package com.lms.soapProducer;

import com.soap.lms.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class LMSEndPoints {
    private static final String NAMESPACE_URI = "http://lms.soap.com";
    private LMSDatabase lmsDatabase;

    @Autowired
    public LMSEndPoints(LMSDatabase lmsDatabase) {
        this.lmsDatabase = lmsDatabase;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "LoginRequest")
    @ResponsePayload
    public LoginResponse Login(@RequestPayload LoginRequest request) throws LMSFault{
        LoginResponse response= new LoginResponse();
        response.setUserLoginInfos(lmsDatabase.findUserId(request.getEmail(), request.getPassword()));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetSearchedBooksRequest")
    @ResponsePayload
    public GetSearchedBooksResponse GetSearchBooks(@RequestPayload GetSearchedBooksRequest request) throws LMSFault {
        GetSearchedBooksResponse response= new GetSearchedBooksResponse();
        if(request.getName() != null) {
            response.getBook().addAll(lmsDatabase.findBooksByName(request.getLoginId(), request.getName()));
        } else if (request.getAuthor() != null) {
            response.getBook().addAll(lmsDatabase.findBooksByAuthor(request.getLoginId(), request.getAuthor()));
        } else if (request.getBookId() != null) {
            response.getBook().add(lmsDatabase.findBookById(request.getLoginId(), request.getBookId()));
        }

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetUserBorrowingInfosRequest")
    @ResponsePayload
    public GetUserBorrowingInfosResponse GetUserBorrowingInfos(@RequestPayload GetUserBorrowingInfosRequest request) throws LMSFault {
        GetUserBorrowingInfosResponse response= new GetUserBorrowingInfosResponse();
        response.getBorrowingInfo().addAll(lmsDatabase.findUserInfo(request.getLoginId(), request.getStudentId()));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "AddBorrowBookRequest")
    @ResponsePayload
    public AddBorrowBookResponse AddBorrowBook(@RequestPayload AddBorrowBookRequest request) throws LMSFault {
        AddBorrowBookResponse response= new AddBorrowBookResponse();
        response.setReturnVal(lmsDatabase.addBorrowBook(request.getLoginId(),
                                                        request.getBorrowBook().getStudentId(),
                                                        request.getBorrowBook().getBookId(),
                                                        request.getBorrowBook().getBorrowingTime(),
                                                        request.getBorrowBook().getDueDate()));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "AddReturnBookRequest")
    @ResponsePayload
    public AddReturnBookResponse AddReturnBook(@RequestPayload AddReturnBookRequest request) throws LMSFault {
        AddReturnBookResponse response= new AddReturnBookResponse();
        response.setReturnVal(lmsDatabase.addReturnBook(request.getLoginId(),
                                                        request.getReturnBook().getStudentId(),
                                                        request.getReturnBook().getBookId(),
                                                        request.getReturnBook().getReturningTime()));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "AddBookRequest")
    @ResponsePayload
    public AddBookResponse AddBook(@RequestPayload AddBookRequest request) throws LMSFault {
        AddBookResponse response= new AddBookResponse();
        response.setBookId(lmsDatabase.addBook(request.getLoginId(),
                                               request.getAddBook().getName(),
                                               request.getAddBook().getType(),
                                               request.getAddBook().getAuthor(),
                                               request.getAddBook().getLocation()));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "DeleteBookRequest")
    @ResponsePayload
    public DeleteBookResponse DeleteBook(@RequestPayload DeleteBookRequest request) throws LMSFault {
        DeleteBookResponse response= new DeleteBookResponse();
        response.setReturnVal(lmsDatabase.deleteBook(request.getLoginId(),
                                                     request.getBookId()));
        return response;
    }
}
