package inflearn.KDSL

import kotlin.properties.Delegates
import kotlin.properties.ReadWriteProperty

/**
 * 완성안함.
 * 소스가 너무 복잡해져 실무에 적용안할듯?
 */
fun main(){
    val yml = dockerCompose {
        version{3}
        service("db"){
            image { "mySql" }
        }
    }
    println(yml.render("  "))
}

fun dockerCompose(init:DockerCompose.()->Unit):DockerCompose{
    val dockerCompose = DockerCompose()
    dockerCompose.init()
    return dockerCompose
}
fun <T> onceNotNull() = object: ReadWriteProperty<Any?, T> {
    private var value:T? = null
    override fun getValue(thisRef: Any?, property: kotlin.reflect.KProperty<*>): T {
        return value ?: throw IllegalStateException("${property.name} not initialized")
    }
    override fun setValue(thisRef: Any?, property: kotlin.reflect.KProperty<*>, value: T) {
        this.value = if(this.value == null) value else throw IllegalStateException("${property.name} already initialized")
    }
}
class DockerCompose{
    private var version:Int by onceNotNull<Int>()
    private val services = mutableListOf<Service>()
    fun version(init:()->Int){
        version = init()
    }
    fun service(name:String,init:Service.()->Unit):Service{
        return Service(name).apply{
            init()
            services.add(this)
        }
    }
    fun render(indent:String):String{
        return StringBuilder().apply {
            appendNew("version: '$version'")
            appendNew("services:")
            appendNew(services.joinToString("\n"){it.render(indent)}.addIndent(indent,1))
        }.toString()
    }
}
class Service(val name:String){
    private var image:String by onceNotNull<String>()
    fun image(init:()->String){
        image = init()
    }
    fun render(indent:String):String{
        return StringBuilder().apply {
            appendNew("$name:")
            appendNew("image: $image",indent,1)
        }.toString()
    }
}
fun StringBuilder.appendNew(str:String,indent:String="",times:Int=0){
    (1..times).forEach { _ -> this.append(indent) }
    this.append(str).append("\n")
}
fun String.addIndent(indent:String, times:Int = 0):String{
    val allIndent = (1..times).joinToString("") { indent }
    return this.split("\n").joinToString { "$allIndent$it" }

}