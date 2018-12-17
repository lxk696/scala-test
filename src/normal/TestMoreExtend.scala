abstract class TestMoreExtend(val parameter:Int) extends  App   {}

trait TraitA {}

trait TraitB {}

trait TraitC {}

object Test1 extends TraitA with TraitB with TraitC {}

//object Test extends ClassName(val parameter:Int){};