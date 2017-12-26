package utils

import java.text.SimpleDateFormat
import java.util.Date

/**
  * author Yuki Hirai on 2017/09/11.
  */
object DateUtil {
  def toFormat(date: Date) = {
    val format = new SimpleDateFormat("yyyy-MM-dd")
    format.format(date)
  }
}
