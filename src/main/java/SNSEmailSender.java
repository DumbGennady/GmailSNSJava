import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;

public class SNSEmailSender {

    public static final String AWS_ACCESS_KEY_ID = "aws.accessKeyId";
    public static final String AWS_SECRET_KEY = "aws.secretKey";

    static {
        System.setProperty(AWS_ACCESS_KEY_ID, {AWS access key id});
        System.setProperty(AWS_SECRET_KEY, {AWS secret key});
    }

    public static void main(String[] args) {

        // Create a new SNS client
        AmazonSNS snsClient = AmazonSNSClient.builder().withRegion(Regions.AP_SOUTH_1).build();

        // Set the parameters for the email notification
        String subject = {message subject};
        String message = {message text};

        PublishRequest publishRequest = new PublishRequest({topic Arn}, message, subject);

        // Send the email notification
        snsClient.publish(publishRequest);

        // Print a message to indicate that the email was sent
        System.out.println("Email sent!");
    }
}
