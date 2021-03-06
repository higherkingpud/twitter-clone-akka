package com.higherkingpud.twitterclone2.infra.mysql

import scalikejdbc._
import scala.concurrent.{Future, ExecutionContext}
import com.higherkingpud.twitterclone2.domain.entities.Follow
import com.higherkingpud.twitterclone2.domain.repositories.FollowRepository
import com.higherkingpud.twitterclone2.infra.mysql.schemas.{FollowSchema, FollowRecord}

class FollowRepositoryOnMySQL (
  session: DBSession,
  executionContext: ExecutionContext
) extends FollowRepository {
  implicit val s: DBSession = session
  implicit val ec: ExecutionContext = executionContext

  val columns: ColumnName[FollowRecord] = FollowSchema.column

  def create(follow: Follow): Future[Unit] = Future {
    withSQL {
      insert.into(FollowSchema).namedValues(
        columns.followerId -> follow.followerId,
        columns.followeeId -> follow.followeeId
      )
    }.update.apply()
  }

  def drop(follow: Follow): Future[Unit] = Future {
    applyUpdate {
      delete.from(FollowSchema)
        .where
        .eq(columns.followerId, follow.followerId)
        .eq(columns.followeeId, follow.followeeId)
    } 
  }
}
