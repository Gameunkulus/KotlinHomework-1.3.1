fun main() {
    timecheck(30)
    timecheck(1800)
    timecheck(1860)
    timecheck(1920)
    timecheck(2100)
    timecheck(3600)
    timecheck(7200)
    timecheck(43200)
    timecheck(75600)
    timecheck(82800)
    timecheck(169520)
    timecheck(172801)

}

fun timecheck(time: Int) {
    val minutes: Int = time / 60
    val hours: Int = time / (60 * 60)
    var timetype = ""
    if (hours > 0) {
        timetype = minuteOuhrs(hours, false)
    } else {
        timetype = minuteOuhrs(minutes, true)
    }

    when {
        time <= 60 -> println("был(а) только что")
        time < (60 * 60) -> println("был(а) ${minutes} $timetype назад")
        time < (24 * 60 * 60) -> println("был(а) ${hours} $timetype назад")
        time < (2 * 24 * 60 * 60) -> println("был(а) сегодня")
        else -> println("был(а) давно")
    }
}

fun minuteOuhrs(time: Int, minutes: Boolean): String {
    val CheckNumber = time % 10
    return when {
        time > 4 && time < 21 -> if (minutes) {
            "минут"
        } else {
            "часов"
        }
        minutes == true -> return when {
            CheckNumber == 0 -> "минут"
            CheckNumber < 2 -> "минуту"
            CheckNumber < 5 -> "минуты"
            else -> "минут"
        }
        else -> return when {
            0 < CheckNumber && CheckNumber < 2 -> "час"
            CheckNumber < 5 -> "часа"
            else -> "часов"
        }
    }
}