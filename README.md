# spring-cloud-feign-hystrix-custom-error
Example usage for custom error code using Feign and Hystrix

# Overview
I found it is hard to understand how does Feign work. 
During my previous project, whenever I returned custom response code, such as 409 or 412, Feign always throws exception and activate circuit breaker (I activated Hystrix). Therefore, once I knew how to do it, I try to put it on my repository as my references.

# Source
There are two source in this repository, one for the API and the other one for Feign purpose.

# Custom Error Decoder
To handle error response codes from the server (4XX or 5XX) in order to make Feign does not throw `HystrixRuntimeException`, I need to create a CustomErrorDecoder and registered it into `application.yml`.
But that is not enough, when the decoder retrieves expected response code, for example 412, then it should throw `HystrixBadRequestException` to by pass the circuit breaker.

    
     public class CustomErrorDecoder implements ErrorDecoder {

        private final ErrorDecoder defaultErrorDecoder = new Default();

        @Override
        public Exception decode(String endpoint, Response response) {
          if(response.status() == 412) {
            throw new HystrixBadRequestException("Error kk", new ValidationException());
          }
          return defaultErrorDecoder.decode(endpoint, response);
        }
      }

See the source code for more details.
