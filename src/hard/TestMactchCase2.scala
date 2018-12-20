object TestMactchCase2 extends App {

  //  密封类（Sealed classes）
  //  Traits 和 classes 都可以被标记为 sealed，这也就意味着所有的子类必须要声明在相同的文件中。这样可以保证所有的子类都是已知的。

  //  这种定义对于模式来说非常有用，因为我们不需要捕获全部的情况。即不必考虑除声明类之外的其它类。
  //  注意
  //  Scala 的模式匹配语句对于通过 case类表示的代数表达式的匹配是最有用的。通过使用提取器对象（extractor objects）中的 unapply 方法，Scala 也允许独立于 case 类（case classes）的模式定义。
  sealed abstract class Notification

  case class Email(sender: String, title: String, body: String) extends Notification

  case class SMS(caller: String, message: String) extends Notification

  case class VoiceRecording(contactName: String, link: String) extends Notification

  def showNotification(notification: Notification): String = {
    notification match {
      //如果notification 是Email 类型。则把如果notification的 参数对应传进来 email11111-》 sender
      case Email(email11111, title1111111, _) =>
        s"You got an email from $email11111 with title: $title1111111"
      //      case SMS(number, message) =>
      //        s"You got an SMS from $number! Message: $message"
      case s: SMS =>
        s"You got an SMS from " + s.caller + "!!!!! Message: " + s.message
      case VoiceRecording(name, link) =>
        s"you received a Voice Recording from $name! Click the link to hear it: $link"
    }
  }

  val someSms = SMS("12345", "Are you there?")
  val someVoiceRecording = VoiceRecording("Tom", "voicerecording.org/id/123")

  println(showNotification(someSms)) //  You got an SMS from 12345! Message: Are you there?
  println(showNotification(someVoiceRecording)) // you received a Voice Recording from Tom! Click the link to hear it: voicerecording.org/id/123

  println("--------------1---------------------")

  // TODO  模式警卫（Pattern guards）
  //  模式警卫是一个简单的布尔表达式，用于使 case 子句更具体。只要在模式后添加 if <boolean expression> 表达式。

  def showImportantNotification(notification: Notification, importantPeopleInfo: Seq[String]): String = {
    notification match {
      case Email(email, _, _) if importantPeopleInfo.contains(email) =>
        "You got an [Important] email from special someone!"
      case SMS(number, _) if importantPeopleInfo.contains(number) =>
        "You got an [Important] SMS from special someone!"
      case other =>
        showNotification(other) // nothing special, delegate to our original showNotification function
    }
  }

  val someImportantSms = SMS("867-5309", "Are you there?")
  val someImportantVoiceRecording = VoiceRecording("Tom", "voicerecording.org/id/123")
  val importantEmail = Email("jenny@gmail.com", "Drinks tonight?", "I'm free after 5!")
  val importantSms = SMS("867-5309", "I'm here! Where are you?")

  val importantPeopleInfo = Seq("867-5309", "jenny111@gmail.com")
  // importantPeopleInfo: Seq[String]
  var showImportantNotification2 = showImportantNotification(_:Notification, importantPeopleInfo)
  println(showImportantNotification2(someImportantSms))
  println(showImportantNotification2(someImportantVoiceRecording))
  println(showImportantNotification2(importantEmail))
  println(showImportantNotification2(importantSms))


  println("--------------2---------------------")

  //  仅匹配类型
  //  你可以像下面这样匹配类型：

  abstract class Device

  case class Phone(model: String) extends Device {
    def screenOff = "Turning screen off"
  }

  case class Computer(model: String) extends Device {
    def screenSaverOn = "Turning screen saver on..."
  }

  def goIdle(device: Device) = device match {
    case p: Phone => p.screenOff
    case c: Computer => c.screenSaverOn
  }


}
