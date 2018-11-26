/*
     Copyright 2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.

     Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file
     except in compliance with the License. A copy of the License is located at

         http://aws.amazon.com/apache2.0/

     or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS,
     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for
     the specific language governing permissions and limitations under the License.
*/

package muctivities;

import com.amazon.ask.Skill;
import com.amazon.ask.SkillStreamHandler;
import com.amazon.ask.Skills;

import muctivities.handlers.CancelandStopIntentHandler;
import muctivities.handlers.DauerIntentHandler;
import muctivities.handlers.FallbackIntentHandler;
import muctivities.handlers.GetActivitysIntent;
import muctivities.handlers.HelpIntentHandler;
import muctivities.handlers.IndoorOutdoorIntentHandler;
import muctivities.handlers.KategorieIntentHandler;
import muctivities.handlers.LaunchRequestHandler;
import muctivities.handlers.MUCtivitiesIntentHandler;
import muctivities.handlers.SessionEndedRequestHandler;
import muctivities.handlers.TippDesTagesHandler;


public class MUCtivitiesStreamHandler extends SkillStreamHandler {

    private static Skill getSkill() {
        return Skills.standard()
                .addRequestHandlers(
                        new LaunchRequestHandler(),
                        new CancelandStopIntentHandler(),
                        new SessionEndedRequestHandler(),
                        new HelpIntentHandler(),
                        new FallbackIntentHandler(),
                        new GetActivitysIntent(),
                        new KategorieIntentHandler(),
                        new IndoorOutdoorIntentHandler(),
                        new DauerIntentHandler(),
                        new MUCtivitiesIntentHandler(),
                        new TippDesTagesHandler()
                )
                // Add your skill id below
                //.withSkillId("")
                .build();
    }

    public MUCtivitiesStreamHandler() {
        super(getSkill());
    }

}
