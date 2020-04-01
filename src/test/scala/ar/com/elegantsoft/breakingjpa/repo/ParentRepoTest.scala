package ar.com.elegantsoft.breakingjpa.repo

import ar.com.elegantsoft.breakingjpa.domain.Parent
import org.apache.logging.log4j.scala.Logging
import org.scalatest.{Matchers, WordSpec}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.TestContextManager

import scala.collection.JavaConverters._

@DataJpaTest
class ParentRepoTest extends WordSpec with Matchers with Logging {
  @Autowired
  val parentRepo: ParentRepo = null

  new TestContextManager(this.getClass).prepareTestInstance(this)

  "ParentRepo" should {
    "save" in {
      parentRepo.save(new Parent("parent1"))
      parentRepo.count() shouldBe 1
    }

    "delete" in {
      val p1 = parentRepo.findAll().get(0)
      parentRepo.delete(p1)
      parentRepo.count() shouldBe 0
    }

    "load" in {
      val ps = Seq(new Parent("parent1"), new Parent("parent2"), new Parent("parent3"))
      parentRepo.saveAll(ps.asJava)
      val all = parentRepo.findAll()
      all should have size 3
      all shouldBe ps.asJava
    }

    "delete all" in {
      parentRepo.count() shouldBe 3
      parentRepo.deleteAll()
      parentRepo.count() shouldBe 0
    }
  }
}
