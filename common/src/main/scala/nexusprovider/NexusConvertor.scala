package nexusprovider

import utils.{Convertor, UserModCommand}


object NexusConvertor extends Convertor {

  def convert(text: String): List[UserModCommand] = {

    val arr = text.split(",")
    val segmentsMap = arr
      .view(3, arr.size)
      .map {
        _ -> arr(0)
      }.toMap

    val userModCommand = new UserModCommand(arr(1), arr(2), segmentsMap)
    userModCommand :: Nil
  }

}
