String repo="parthibanposhmark/hello-world"

dashboardView('example') {
    jobs {
        regex(/example1/)
    }
    columns {
        status()
        weather()
        name()
        lastSuccess()
        lastFailure()
        lastDuration()
        buildButton()
        favorite()
    }
    topPortlets {
        unstableJobs{
        	displayName('Unstable Jobs')
        }
    }
}

job("example1"){
	scm{
		github repo
	}
	triggers{
		scm 'H/5 * * * *'
	}
} 