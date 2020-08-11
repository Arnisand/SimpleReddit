package com.arnisand.simplereddit.domain.model.network.article

import com.google.gson.*
import java.lang.reflect.Type
import java.util.*
import kotlin.collections.ArrayList

class RedditArticleListDeserializer : JsonDeserializer<RedditTopArticleAnswer> {

    @Throws(JsonParseException::class)
    override fun deserialize(json: JsonElement, typeOfT: Type?, context: JsonDeserializationContext?): RedditTopArticleAnswer {
        val items = ArrayList<RedditArticleDto>()
        val jsonObject: JsonObject = json.asJsonObject

        val childrenNode = jsonObject.get("data").asJsonObject.get("children").asJsonArray
        for (jsonElement in childrenNode) {
            val childDataNode = jsonElement.asJsonObject.get("data").asJsonObject
            val name = childDataNode.get("name").asString
            val title = childDataNode.get("title").asString
            val thumbnail = childDataNode.get("thumbnail").asString
            val created = childDataNode.get("created").asLong
            val author = childDataNode.get("author").asString
            val numComments = childDataNode.get("num_comments").asInt

            items.add(RedditArticleDto(name, title, author, Date(created), thumbnail, numComments))
        }

        return RedditTopArticleAnswer(items.toList())
    }
}