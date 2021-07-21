package Sheet

object Reservation {

  //var array name = Array(Array(), Array())
  var seatColomboMattala = Array(Array(0,0,0,0,0),
    Array(0,0,0,0,0),
    Array(0,0,0,0,0),
    Array(0,0,0,0,0))

  var seatMattalaRathmalana = Array(Array(0,0,0,0,0),
    Array(0,0,0,0,0),
    Array(0,0,0,0,0),
    Array(0,0,0,0,0))

  var seatRathmalanaDilli = Array(Array(0,0,0,0,0),
    Array(0,0,0,0,0),
    Array(0,0,0,0,0),
    Array(0,0,0,0,0))

  var seatDilliMombai = Array(Array(0,0,0,0,0),
    Array(0,0,0,0,0),
    Array(0,0,0,0,0),
    Array(0,0,0,0,0))



  def returnIndex(city:String):Int={
    city match {
      case "Colombo"=>
        return 1
      case "Mattala"=>
        return 2
      case "Rathmalana"=>
        return 3
      case "Dilli"=>
        return 4
      case "Mombai"=>
        return 5

    }
  }

  def returnCitySeat(index:Int):Array[Array[Int]]={
    index match {
      case 1 =>
        return seatColomboMattala
      case 2 =>
        return seatMattalaRathmalana
      case 3 =>
        return seatRathmalanaDilli
      case 4 =>
        return seatDilliMombai

    }
  }

  def reserveSeat(start:String, end:String, row:Int, seatNum:Int):Unit={
    var num1 = returnIndex(start)
    var num2 = returnIndex(end)
    var i = 0
    var test = 0

    for(i <- num1 to num2-1){

      if(returnCitySeat(i)(row-1)(seatNum-1) == 1){
        test = 1
      }
    }

    if(test == 0)
    {
      for(i <- num1 to num2-1){
        returnCitySeat(i)(row-1)(seatNum-1) = 1
      }
      println("Your Request succussfull, Reserved seat "+row+" . "+seatNum )
    }
    else{
      println("Your request cannot set, please try another seat")
    }




  }

  def printPlan(plan:Array[Array[Int]]):Unit={
    var i = 0
    var j = 0
    print("seatNum : ")
    for(i <- 0 to 4){
      print(" " + (i+1))
    }
    println()
    for(i <- 0 to 3){
      print(i+1+" Row   : ")
      for(j <- 0 to 4){
        print(" "+plan(i)(j))
      }
      println()
    }
    println()
  }


  def main(args: Array[String]): Unit = {

    println("Colombo     =    1")
    println("Mattala     =    2")
    println("Rathmalana  =    3")
    println("Dilli       =    4")
    println("Mombai      =    5")
    println()

    reserveSeat("Colombo", "Mattala", 2,4)
    reserveSeat("Rathmalana", "Dilli", 2, 4)
    reserveSeat("Mattala", "Rathmalana", 2, 4)
    reserveSeat("Rathmalana", "Mombai", 1, 3)

    printPlan(seatColomboMattala)
    printPlan(seatMattalaRathmalana)
    printPlan(seatRathmalanaDilli)
    printPlan(seatDilliMombai)


  }
}
