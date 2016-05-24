import StreamingAppContext.AppConfig

object Main extends App {

  val parser = new scopt.OptionParser[AppConfig]("streaming-unifier") {
    opt[String]('b', "broker").required().text("broker specification is required")
      .action { (x, c) => c.copy(broker = x) }
    opt[String]('i', "input-topics").required().text("input topics are required")
      .action { (x, c) => c.copy(inputTopics = x) }
    opt[String]('o', "output-topic").required().text("output topic is required")
      .action { (x, c) => c.copy(outputTopic = x) }
    opt[String]('p', "provider-type").required().text("provider type selection is required")
      .action { (x, c) => c.copy(provider_type = x) }
  }

  parser.parse(args, AppConfig()) match {
    case Some(config) => {
      StreamingAppContext.runStreamingJobs(config)
    }
    case None => {
      println("Invalid input")
      System.exit(1)
    }
  }

}
