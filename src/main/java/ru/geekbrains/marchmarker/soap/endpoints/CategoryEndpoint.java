package ru.geekbrains.marchmarker.soap.endpoints;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ru.geekbrains.marchmarker.soap.categories.GetCategoryByTitleRequest;
import ru.geekbrains.marchmarker.soap.categories.GetCategoryByTitleResponse;
import ru.geekbrains.marchmarker.soap.services.SoapCategoryService;

@Endpoint
@RequiredArgsConstructor
public class CategoryEndpoint {
    private static final String NAMESPACE_URI = "http://www.geekbrains.ru/marchmarker/categories";
    private final SoapCategoryService categoryService;

    /*
        Пример запроса: POST http://localhost:8080/ws

        <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
          xmlns:f="http://www.flamexander.com/spring/ws/groups">
            <soapenv:Header/>
            <soapenv:Body>
                <f:getGroupByTitleRequest>
                    <f:title>ABC-123</f:title>
                </f:getGroupByTitleRequest>
            </soapenv:Body>
        </soapenv:Envelope>
     */

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCategoryByTitleRequest")
    @ResponsePayload
    @Transactional
    public GetCategoryByTitleResponse getCategoryByTitle(@RequestPayload GetCategoryByTitleRequest request) {
        GetCategoryByTitleResponse response = new GetCategoryByTitleResponse();
        response.setCategory(categoryService.getByTitle(request.getTitle()));
        return response;
    }
}