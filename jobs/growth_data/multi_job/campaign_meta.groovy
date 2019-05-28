multiJob('gdf-multi_job/gd-multi_job-campaign_meta') {
  description("<html>"+
  "<br/>"+
  "<br/>"+
  "<table>"+
    "<tr>"+
      "<td style='font-family: Consolas,monospace; '>"+
       "<b>Description  </b>"+  
      "</td>"+
      "<td style='font-family: Consolas,monospace;'>"+
        ": Multi job which triggers all the tasks that were pulling campaign meta information from different Ad partners "+
      "</td>"+
    "</tr>"+
    
    "<tr>"+
      "<td style='font-family: Consolas,monospace; '>"+
       "<b>Updates Table  </b>"+  
      "</td>"+
      "<td style='font-family: Consolas,monospace;'>"+
        ":  analytics.dw_growth_campaign "+
      "</td>"+
    "</tr>"+

    "<tr>"+
      "<td style='font-family: Consolas,monospace; '>"+
       "<b>Owner  </b>"+  
      "</td>"+
      "<td style='font-family: Consolas,monospace;'>"+
        ":  kamal@poshmark.com, parthiban@poshmark.com "+
      "</td>"+
    "</tr>"+

    "<tr>"+
      "<td style='font-family: Consolas,monospace; '>"+
       "<b>Git  </b>"+  
      "</td>"+
      "<td style='font-family: Consolas,monospace;'>"+
        ": NA"+
      "</td>"+
    "</tr>"+
    
    "<tr>"+
      "<td style='font-family: Consolas,monospace; '>"+
       "<b>JIRA </b>"+  
      "</td>"+
      "<td style='font-family: Consolas,monospace;'>"+
        ": NA"+
      "</td>"+
    "</tr>"+

  "</table>"+
"</html>")

  parameters{
    booleanParam('upload_to_s3', true, null)
  }

  weight(1)

  label('slave')

  disabled(true)

  scm{
     git{
      branch('*/master')
      remote{
        url('https://github.com/ParthibanPoshmark/hello-world')
      }
     }
  }

  triggers{
    cron('H * * * *')
  }

  wrappers {
    timeout {
      absolute('10')
    }
  }

  steps{
    phase('1'){
      phaseJob('gdf-facebook/gd-facebook-campaign_meta'){
      killPhaseCondition('NEVER')
      currentJobParameters(true)
      }
      phaseJob('gdf-other_partners/gd-other_partners-bing_campaign_meta'){
      killPhaseCondition('NEVER')
      currentJobParameters(true)
      }
       phaseJob('gdf-other_partners/gd-other_partners-apple_campaign_meta'){
      killPhaseCondition('NEVER')
      currentJobParameters(true)
      }
       phaseJob('gdf-other_partners/gd-other_partners-criteo_campaign_meta'){
      killPhaseCondition('NEVER')
      currentJobParameters(true)
      }
       phaseJob('gdf-google/gd-google-campaign_meta'){
      killPhaseCondition('NEVER')
      currentJobParameters(true)
      }
       phaseJob('gdf-snapchat/gd-snapchat-campaign_meta'){
      killPhaseCondition('NEVER')
      currentJobParameters(true)
      }
       phaseJob('gdf-pinterest/gd-pinterest-campaign_meta'){
      killPhaseCondition('NEVER')
      currentJobParameters(true)
      }
       phaseJob('gdf-other_partners/gd-other_partners-yahoo_campaign_meta'){
      killPhaseCondition('NEVER')
      currentJobParameters(true)
      }
       phaseJob('gdf-other_partners/gd-other_partners-unity_campaign_meta'){
      killPhaseCondition('NEVER')
      currentJobParameters(true)
      }
       phaseJob('gdf-other_partners/gd-other_partners-taboola_campaign_meta'){
      killPhaseCondition('NEVER')
      currentJobParameters(true)
      abortAllJobs(true)
      }
      executionType('SEQUENTIALLY')
      continuationCondition('ALWAYS')
      abortAllJobs(true)
    }
  }

}
