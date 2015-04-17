package controllers

import play.api._
import play.api.mvc._
import com.twilio.sdk.client.TwilioCapability
import com.twilio.sdk.verbs._

object Application extends Controller {

  val AccountSid = System.getenv("TWILIO_ACCOUNT_SID")
  val AuthToken = System.getenv("TWILIO_AUTH_TOKEN")
  val ApplicationSid = System.getenv("TWILIO_APPLICATION_SID")
  val PhoneNumber = System.getenv("TWILIO_PHONE_NUMBER")
  val CallerId = System.getenv("TWILIO_CALLER_ID")
  
  def index = Action {
    val capability = new TwilioCapability(AccountSid, AuthToken)
    capability.allowClientOutgoing(ApplicationSid)
    val token = capability.generateToken()
    
    Ok(views.html.index(token))
  }

  def voice = Action {
    val twiml = new TwiMLResponse()
    val dial = new Dial()
    dial.append(new Number(PhoneNumber))
    dial.setCallerId(CallerId)
    twiml.append(dial)
    Ok(twiml.toXML()).as("application/xml")
  }
  
}