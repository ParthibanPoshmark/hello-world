freeStyleJob('gdf-pinterest/gd-pinterest-adset_meta') {
  description("<html>"+
  "<br/>"+
  "<br/>"+
  "<table>"+
    "<tr>"+
      "<td style='font-family: Consolas,monospace; '>"+
       "<b>Description  </b>"+  
      "</td>"+
      "<td style='font-family: Consolas,monospace;'>"+
        ": Pulls adset meta information from pinterest "+
      "</td>"+
    "</tr>"+
    
    "<tr>"+
      "<td style='font-family: Consolas,monospace; '>"+
       "<b>Updates Table  </b>"+  
      "</td>"+
      "<td style='font-family: Consolas,monospace;'>"+
        ":  analytics.dw_growth_adset "+
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
       "<b>Rake File  </b>"+  
      "</td>"+
      "<td style='font-family: Consolas,monospace;'>"+
        ": pinterest/adset_meta.rake "+
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

  weight(2)
  
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

  wrappers{
    timeout{
      elastic(200,3,180)
    }
  }

  steps{
    shell('#!/bin/bash --login -x\n\nbash $WORKSPACE/docker_scripts/pintrest/import_ad_meta_pin_api.sh')
  }

}
