package org.creative.usermanager.persistence

import org.creative.usermanager.persistence.entity.{CustomerComponent, UserComponent}
import slick.jdbc.PostgresProfile.api._

import scala.concurrent.Future

trait SchemaCreatorImpl extends UserComponent with CustomerComponent {

  val db = Database.forConfig("database")

  def createSchema(): Future[Unit] = {

    val action = (users.schema ++ customers.schema).create
    db.run(action)
  }
}