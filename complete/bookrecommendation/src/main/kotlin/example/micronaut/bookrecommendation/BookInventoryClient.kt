//tag::packageandimports[]
package example.micronaut.bookrecommendation

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Consumes
import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client
import io.micronaut.retry.annotation.Recoverable
import io.reactivex.Maybe

import javax.validation.constraints.NotBlank

//end::packageandimports[]
/*
//tag::harcoded[]
@Client("http://localhost:8082") // <1>
@Recoverable(api = BookInventoryOperations::class)
//end::harcoded[]
*/
//tag::eureka[]
@Client(id = "bookinventory") // <1>
@Recoverable(api = BookInventoryOperations::class)
//end::eureka[]
//tag::clazz[]
interface BookInventoryClient : BookInventoryOperations {

    @Consumes(MediaType.TEXT_PLAIN)
    @Get("/books/stock/{isbn}")
    override fun stock(@NotBlank isbn: String): Maybe<Boolean>
}
//end::clazz[]
