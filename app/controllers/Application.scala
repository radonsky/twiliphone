package controllers

import play.api._
import play.api.mvc._
import com.twilio.sdk.client.TwilioCapability

object Application extends Controller {

  val AccountSid = System.getenv("TWILIO_ACCOUNT_SID")
  val AuthToken = System.getenv("TWILIO_AUTH_TOKEN")
  val ApplicationSid = System.getenv("TWILIO_APPLICATION_SID")
  
  def index = Action {
    val capability = new TwilioCapability(AccountSid, AuthToken)
    capability.allowClientOutgoing(ApplicationSid)
    val token = capability.generateToken()
    
    Ok(views.html.index(token))
  }

}