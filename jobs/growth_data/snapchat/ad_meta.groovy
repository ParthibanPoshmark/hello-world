freeStyleJob('gdf-snapchat/gd-snapchat-ad_meta') {
	description("<html>"+
  "<br/>"+
  "<br/>"+
  "<table>"+

    "<tr>"+
      "<td style='font-family: Consolas,monospace; '>"+
       "<b>Description	</b>"+	
      "</td>"+
      "<td style='font-family: Consolas,monospace;'>"+
        ": Pulls ad and adset meta information from snapchat "+
      "</td>"+
   	"</tr>"+
    
    "<tr>"+
      "<td style='font-family: Consolas,monospace; '>"+
       "<b>Updates Table	</b>"+	
      "</td>"+
      "<td style='font-family: Consolas,monospace;'>"+
        ": 	analytics.dw_growth_ad, analytics.dw_growth_adset "+
      "</td>"+
   	"</tr>"+

   	"<tr>"+
      "<td style='font-family: Consolas,monospace; '>"+
       "<b>Owner	</b>"+	
      "</td>"+
      "<td style='font-family: Consolas,monospace;'>"+
        ": 	kamal@poshmark.com, parthiban@poshmark.com "+
      "</td>"+
   	"</tr>"+

   	"<tr>"+
      "<td style='font-family: Consolas,monospace; '>"+
       "<b>Rake File	</b>"+	
      "</td>"+
      "<td style='font-family: Consolas,monospace;'>"+
        ":	snapchat/ad_meta.rake"+
      "</td>"+
   	"</tr>"+

   	"<tr>"+
      "<td style='font-family: Consolas,monospace; '>"+
       "<b>Git	</b>"+	
      "</td>"+
      "<td style='font-family: Consolas,monospace;'>"+
        ": NA"+
      "</td>"+
   	"</tr>"+
    
    "<tr>"+
      "<td style='font-family: Consolas,monospace; '>"+
       "<b>JIRA	</b>"+	
      "</td>"+
      "<td style='font-family: Consolas,monospace;'>"+
        ": NA"+
      "</td>"+
   	"</tr>"+

  "</table>"+
"</html>")

  parameters{
    booleanParam('upload_to_s3', true, null)
    stringParam('accounts', null , null)
    stringParam('effective_status', 'ACTIVE' , null)
  }

  weight(2)
  
  label('slave')

  scm{
     git{
      branch('*/master')
      remote{
        url('https://github.com/ParthibanPoshmark/hello-world')
      }
     }
  }

  triggers{
    cron('30 H/4 * * * ')
  }

  wrappers{
    timeout{
      elastic(200,3,30)
    }
  }

  steps{
      shell('#!/bin/bash --login -x\n\nCMD="$(aws ecr get-login --region us-west-1)"\nbash -lc "$CMD"\ndocker pull 666737672436.dkr.ecr.us-west-1.amazonaws.com/automator:latest\ndocker run \
      -e TZ="America/Los_Angeles" \
      -e LANG=en_US.UTF-8 \
      --network host \
      --add-host yaga-a1:10.1.56.202 \
      --add-host yaga-a2:10.1.56.56 \
      --add-host yaga-a3:10.1.68.194 \
      --memory="8g" --sig-proxy=true --net="host" --privileged --memory-swappiness="0" --shm-size="8g" -w /goshposh/automator --rm -u ubuntu 666737672436.dkr.ecr.us-west-1.amazonaws.com/automator \
      /bin/bash -lc \
      "cd /goshposh/automator/ruby/ && \
      rvm use ruby-2.3.1@automator && \
      export upload_to_s3=$upload_to_s3 && \
      export BUILD_URL=$BUILD_URL && \
      export JOB_NAME=$JOB_NAME && \
      export effective_status=$effective_status && \
      export accounts=$accounts && \
      bundle exec rake snapchat:ad_meta  RAKE_ENV=docker_production --trace && \
      if [ \"$?\" != \"0\" ]; then exit 1; fi" ')
  }

}