String repo="parthibanposhmark/hello-world"

dashboardView('example') {
    jobs {
        regex(/example1/)
    }
    columns {
        status()
        weather()
        lastSuccess()
        lastFailure()
        lastDuration()
        buildButton()
    }
    topPortlets {
        jenkinsJobsList {
			displayName('Jobs')
			}
	    }
	}

	folder('project-a') {
    displayName('Project A')
    description('Folder for project A')
}

job("project-a/example1"){
	scm{
		github repo
	}
	triggers{
		scm 'H/10 * * * *'
	}
}