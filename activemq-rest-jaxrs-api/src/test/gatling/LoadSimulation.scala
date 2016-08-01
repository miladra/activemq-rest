/**
 * Copyright 2011-2016 GatlingCorp (http://gatling.io)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package computerdatabase

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class LoadSimulation extends Simulation {

  val httpConf = http
    .baseURL("http://localhost:8080") // Here is the root for all relative URLs
    .acceptHeader("application/json") // Here are the common headers
    .contentTypeHeader("application/json")

  val scn = scenario("Load Test Producer") // A scenario is a chain of requests and pauses
    .during(60 seconds) {
      exec(http("producer_1")
        .post("/messages/TEST.FOO")
        .body(StringBody("""{"headers":{"foo": "baz"},"body":"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer suscipit, libero quis gravida placerat, quam sem blandit augue, ut hendrerit justo elit pulvinar lectus. Sed sed nunc in metus fringilla egestas. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Maecenas ac tempor nulla. Suspendisse pulvinar, tortor consequat porttitor imperdiet, mi metus rutrum ipsum, a viverra dolor est ac mauris. Morbi finibus urna et risus fermentum blandit. Praesent iaculis mollis augue, hendrerit accumsan tortor commodo eu. Sed placerat nisl non nunc pellentesque efficitur. Duis metus lorem, auctor non blandit eget, rutrum at sapien. Quisque euismod non dolor et auctor. Cras egestas justo in ex convallis, vitae malesuada lacus sollicitudin. Curabitur tempor blandit lorem, non facilisis libero varius nec. Proin sit amet dolor volutpat, tincidunt leo feugiat, euismod magna. Proin et velit tempus, imperdiet enim lobortis, tristique arcu. Vivamus pellentesque pretium lectus vitae hendrerit. Suspendisse fermentum, leo at consectetur cursus, risus enim faucibus ex, eget volutpat lorem massa eu tortor. Sed molestie, urna sit amet faucibus tempus, turpis tellus mollis risus, quis dictum augue sem vitae magna. Nulla ultrices diam in ullamcorper porta. Sed sollicitudin facilisis tortor eget imperdiet. Aliquam tincidunt justo sed augue efficitur, a volutpat risus pellentesque. Aenean tincidunt tortor tortor, ut hendrerit mi elementum nec. Ut lobortis quam nec nulla condimentum iaculis. Nam imperdiet mauris ac dui tincidunt, vitae sodales leo volutpat. Pellentesque luctus erat quis augue tincidunt, a accumsan sem finibus. Suspendisse potenti. Praesent leo tellus, aliquet mattis rhoncus ac, molestie eget justo. Etiam ante mauris, tincidunt sed mauris at, tempus vestibulum dui. Vivamus luctus id lorem nec feugiat. Maecenas hendrerit vehicula ex eget faucibus. Vestibulum ultrices erat ligula, vitae auctor purus commodo non. Duis id malesuada orci, ac congue lorem. Pellentesque malesuada elit at aliquet dignissim. In at nulla a lorem dictum congue. Nam eu velit sed enim luctus tristique. Nullam malesuada condimentum consequat. Nam commodo enim eget lorem semper dictum. Suspendisse erat odio, vestibulum non nibh in, fringilla rhoncus felis. Nullam urna purus, tempus vitae urna ac, placerat sagittis justo. Fusce gravida congue nisi ac fermentum. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Maecenas at mauris lobortis, molestie magna id, vulputate mauris. Phasellus nec dolor magna. In ullamcorper nulla commodo, rhoncus quam a, ornare risus. Integer in quam ac quam hendrerit tincidunt. Nulla facilisis et leo ut interdum. Etiam eu nunc imperdiet, interdum nibh ut, laoreet nisi. Sed luctus mauris sed sem ullamcorper, non vestibulum dui facilisis. Phasellus aliquam ornare sem, vitae scelerisque turpis imperdiet at. Nulla eget lacus sed ligula convallis suscipit. Sed iaculis porta mauris, nec varius odio euismod ut. Vestibulum at ipsum vitae metus eleifend dignissim quis eget nunc. Maecenas ornare tortor at nisl tristique facilisis. Vestibulum lacinia suscipit nulla. Phasellus tortor ante, maximus non consequat quis, mattis a lacus. Sed nunc orci, malesuada at augue at, pharetra iaculis felis. Cras rutrum dictum efficitur. Vestibulum non bibendum lorem. Phasellus nec imperdiet eros. Ut sed mi lacus. Mauris eget convallis mi. Morbi et maximus neque, ac volutpat orci. Aenean eget pretium libero. Aliquam facilisis, velit ac gravida tristique, magna elit laoreet lectus, sed dignissim ligula diam et justo. Duis id mauris purus. Nam venenatis lacus ac eros placerat, ut pellentesque purus finibus. Phasellus eleifend leo ac eros luctus, eu dignissim purus dictum. Nam elementum volutpat dui, sit amet congue nulla. Sed vehicula hendrerit nisi, a tincidunt libero molestie ac. Praesent pharetra nunc eu pharetra ornare. Nullam sem metus, egestas ut lectus non, efficitur placerat libero. Curabitur venenatis elit a auctor scelerisque. Phasellus fermentum suscipit purus quis feugiat. Nam felis arcu, varius sit amet augue nec, sagittis lacinia arcu. Nullam molestie ex et purus tincidunt, mattis tristique magna pharetra. Ut semper, libero sit amet fringilla condimentum, elit libero scelerisque diam, vel sagittis tortor nisl ut ipsum. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque at tellus tincidunt, suscipit urna quis, lacinia nisi. Mauris molestie varius nisi, ac condimentum est condimentum eget. Vivamus tortor tortor, dictum quis nunc consequat, molestie elementum tortor. Vivamus vel aliquet eros. Pellentesque feugiat diam eu est iaculis dapibus. Suspendisse vel tristique massa. Pellentesque rhoncus suscipit ultricies. Suspendisse magna leo, cursus non rutrum vitae, laoreet non justo. Vestibulum volutpat, ipsum vitae dignissim semper, lorem urna posuere lectus, a tempus ex tellus eu purus. Curabitur cursus urna ac metus ornare condimentum. Vestibulum accumsan, ipsum consequat iaculis sagittis, nisl mauris venenatis purus, fringilla tincidunt odio elit at augue. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed bibendum, ex maximus ultrices tristique, neque orci vestibulum sapien, vel tempus libero nibh a metus. Sed blandit eros nec imperdiet bibendum. Fusce cursus felis dui, porta eleifend leo iaculis eu. Mauris in neque est. Sed et ullamcorper justo, quis varius dolor. Duis ac odio at neque laoreet tristique in in sapien. Suspendisse porta congue scelerisque. Suspendisse bibendum porta leo, sed hendrerit velit efficitur id. Mauris bibendum diam id ante imperdiet ullamcorper. Phasellus bibendum porta urna, ac venenatis sem maximus ac. In placerat, sem non pellentesque ornare, nulla dui feugiat dolor, vel finibus risus felis a tortor. Donec bibendum mauris eget nibh feugiat convallis eu vitae turpis. Praesent facilisis nibh nec suscipit imperdiet. Donec in ex dolor. Ut at lorem ipsum. Phasellus molestie, nisi et lacinia elementum, metus nisi gravida augue, sed ultricies sapien libero in nisl. Duis eu porta magna. Proin cursus fringilla justo vitae laoreet. Cras blandit dolor nec metus luctus auctor. Morbi risus augue, egestas quis ultrices ut, imperdiet in lectus. Quisque condimentum ac justo et mattis. Cras eget leo at arcu vulputate mollis eu eget magna. Phasellus et felis ut sapien semper consequat non eget eros. Donec leo nibh, tempor in auctor eleifend, auctor eu leo. Nulla bibendum ipsum eu risus efficitur, vel posuere nunc convallis. Donec nec sem sit amet nunc aliquet accumsan quis at est. Phasellus nulla arcu, interdum vel purus nec, accumsan luctus lectus. Nam laoreet gravida dolor. Morbi aliquet mattis lorem, nec commodo metus maximus ac. Aliquam vehicula rhoncus lobortis. Pellentesque fermentum, odio eget dignissim luctus, magna nunc lobortis felis, non vulputate lectus massa id urna. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Proin ut ex in magna efficitur euismod at tempor lectus. Duis in velit interdum nunc pellentesque porttitor. Vivamus viverra venenatis elementum. Etiam pretium, metus sit amet sollicitudin pretium, mi risus posuere lorem, vel cursus neque lectus a sapien. Phasellus porta elit nec nisl volutpat, a consectetur augue cursus. Vestibulum ultricies non odio ac lobortis. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Suspendisse eget lacinia erat. Proin vulputate cursus mauris, at luctus nibh lobortis ac. Mauris at augue sollicitudin, ultrices ligula sit amet, mattis justo. In hac habitasse platea dictumst. Proin fermentum tincidunt quam, eu tempor ante egestas eu. Aliquam erat volutpat. Vivamus a iaculis enim. Quisque ut faucibus mi, sed interdum diam. Quisque eget justo pharetra, efficitur est facilisis, placerat elit. Curabitur lobortis aliquet neque et eleifend. Nunc tincidunt fringilla diam eu pulvinar. Integer placerat in sem sed tincidunt. Suspendisse at libero nec est consectetur pretium a id libero. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut blandit lectus quis mi egestas, a venenatis nisl feugiat. Quisque iaculis dictum lacus a venenatis. Vestibulum sit amet semper leo, a facilisis odio. Mauris bibendum, ipsum in mattis vestibulum, nunc felis suscipit ante, ut tincidunt leo metus at mi. Aenean condimentum odio nec leo gravida lacinia. Proin fringilla augue a ligula imperdiet pharetra. In interdum ante id lectus accumsan, quis laoreet dui iaculis. Nulla erat orci, interdum ut luctus et, porttitor vehicula nisl. Nunc tincidunt lacus vel turpis finibus, vitae blandit leo pretium. Maecenas in augue vitae est vestibulum efficitur quis non tellus. Donec facilisis risus vel porttitor iaculis. Aliquam cursus mauris non sapien lobortis, a ultricies lacus euismod. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nunc mattis urna volutpat eros vulputate luctus. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec neque nisl, suscipit at feugiat a, pellentesque eu ligula. Aenean sodales a ante nec posuere. Donec quis nulla ut ex accumsan commodo at eget sapien. Sed scelerisque erat in quam dapibus, ac efficitur mauris pharetra. Maecenas nec est neque. Duis ac egestas velit. Mauris sodales nunc tortor, nec fermentum lorem luctus vitae. Praesent ullamcorper volutpat sapien quis tristique. Quisque vel dolor vehicula, efficitur nibh vel, varius odio. Suspendisse a orci sed massa bibendum ornare sit amet in lectus. Fusce eu eros sit amet metus pulvinar mattis eget nec lectus. Aliquam sollicitudin accumsan lacinia. Vivamus sollicitudin diam eu quam elementum, eget efficitur turpis rutrum. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Morbi faucibus accumsan aliquet. Vestibulum sed lorem fermentum, pellentesque velit at, fringilla lectus. Nullam aliquet posuere magna, eget bibendum ex. Duis sit amet efficitur ex viverra fusce."}""")))
    }

  setUp(scn.inject(atOnceUsers(100)).protocols(httpConf))
}
