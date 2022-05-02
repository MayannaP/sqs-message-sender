package services;

import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.GetQueueUrlRequest;
import software.amazon.awssdk.services.sqs.model.GetQueueUrlResponse;

public class SqsService {
	
	public static void sqsService(String message) { 
		
		SqsClient sqsClient = ClientAuth.clientAuth();
	
		GetQueueUrlRequest request = GetQueueUrlRequest.builder()
	            .queueName("test-1") 
	            .queueOwnerAWSAccountId("179875587592").build();
	    GetQueueUrlResponse createResult = sqsClient.getQueueUrl(request);
	    
	    MessageSender.sendMessage(sqsClient, createResult.queueUrl(), message);
	
	    sqsClient.close();
	}	
}
